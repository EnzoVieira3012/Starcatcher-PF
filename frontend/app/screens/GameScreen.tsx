import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Alert, ImageBackground } from 'react-native';
import { useRouter } from 'expo-router';
import { fetchRandomQuestions, checkAnswer } from '../../src/services/api'; // Importa os métodos

interface Question {
  id: number;
  questionText: string;
  answers: string[];
}

const GameScreen = () => {
  const [questions, setQuestions] = useState<Question[]>([]);
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [score, setScore] = useState(0);
  const [selectedAnswer, setSelectedAnswer] = useState<string | null>(null); // Resposta selecionada
  const [answerStatus, setAnswerStatus] = useState<'correct' | 'wrong' | null>(null); // Status da resposta
  const router = useRouter();

  useEffect(() => {
    const fetchQuestions = async () => {
      try {
        const response = await fetchRandomQuestions(); // Busca as perguntas
        setQuestions(response.data);
      } catch (error) {
        console.error('Erro ao buscar perguntas:', error);
        Alert.alert('Erro', 'Não foi possível buscar as perguntas. Verifique sua conexão.');
      }
    };

    fetchQuestions();
  }, []);

  const handleAnswer = async (answer: string) => {
    if (selectedAnswer) return; // Bloqueia múltiplos cliques após selecionar uma resposta

    const currentQuestion = questions[currentQuestionIndex];
    setSelectedAnswer(answer); // Define a resposta selecionada

    try {
      // Verifica se a resposta está correta
      const response = await checkAnswer(currentQuestion.id, answer);
      const { correct } = response.data;

      if (correct) {
        setAnswerStatus('correct'); // Resposta correta
        setScore(score + 1); // Incrementa o score
      } else {
        setAnswerStatus('wrong'); // Resposta errada
      }
    } catch (error) {
      console.error('Erro ao verificar resposta:', error);
      Alert.alert('Erro', 'Não foi possível verificar a resposta.');
    }
  };

  const nextQuestion = () => {
    // Avança para a próxima pergunta
    if (currentQuestionIndex < questions.length - 1) {
      setCurrentQuestionIndex(currentQuestionIndex + 1);
      setSelectedAnswer(null); // Reseta a resposta selecionada
      setAnswerStatus(null); // Reseta o status da resposta
    } else {
      // Navega para a tela de resultados ao final do jogo
      router.push({
        pathname: '/result',
        params: {
          score: score.toString(),
          total: questions.length.toString(),
        },
      });
    }
  };

  if (questions.length === 0) {
    return (
      <ImageBackground
        source={require('../../assets/images/background.jpg')} // Imagem do fundo
        style={styles.background}
      >
        <View style={styles.container}>
          <Text style={styles.title}>Carregando perguntas...</Text>
        </View>
      </ImageBackground>
    );
  }

  const currentQuestion = questions[currentQuestionIndex];

  return (
    <ImageBackground
      source={require('../../assets/images/background.jpg')} // Imagem do fundo
      style={styles.background}
    >
      <View style={styles.container}>
        <Text style={styles.title}>{currentQuestion.questionText}</Text>
        {currentQuestion.answers.map((answer, index) => (
          <TouchableOpacity
            key={index}
            style={[
              styles.button,
              selectedAnswer === answer && answerStatus === 'correct' && styles.correctButton, // Botão verde
              selectedAnswer === answer && answerStatus === 'wrong' && styles.wrongButton, // Botão vermelho
            ]}
            onPress={() => handleAnswer(answer)}
            disabled={!!selectedAnswer} // Desativa cliques após selecionar uma resposta
          >
            <Text style={styles.buttonText}>{answer}</Text>
          </TouchableOpacity>
        ))}
        {selectedAnswer && (
          <TouchableOpacity style={styles.nextButton} onPress={nextQuestion}>
            <Text style={styles.nextButtonText}>Próxima Pergunta</Text>
          </TouchableOpacity>
        )}
      </View>
    </ImageBackground>
  );
};

const styles = StyleSheet.create({
  background: {
    flex: 1, // Ocupa toda a tela
    resizeMode: 'cover', // Redimensiona para cobrir a tela
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'rgba(0, 0, 0, 0.5)', // Fundo semitransparente sobre a imagem
    padding: 20,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#fff', // Texto na cor branca
    marginBottom: 20,
    textAlign: 'center',
  },
  button: {
    backgroundColor: '#fff', // Botão com fundo branco
    padding: 15,
    borderRadius: 10,
    marginVertical: 10,
    width: '100%',
    alignItems: 'center',
  },
  correctButton: {
    backgroundColor: '#4CAF50', // Verde para resposta correta
  },
  wrongButton: {
    backgroundColor: '#F44336', // Vermelho para resposta errada
  },
  buttonText: {
    color: '#000', // Texto do botão na cor preta
    fontSize: 18,
    fontWeight: 'bold',
  },
  nextButton: {
    marginTop: 20,
    backgroundColor: '#4CAF50',
    padding: 15,
    borderRadius: 10,
    width: 200,
    alignItems: 'center',
  },
  nextButtonText: {
    color: '#fff',
    fontSize: 18,
    fontWeight: 'bold',
  },
});

export default GameScreen;