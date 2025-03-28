import axios from 'axios';

const api = axios.create({
  baseURL: 'http://192.168.15.48:8080/api', // Substitua pelo IP do seu computador
});

export const fetchRandomQuestions = async () => {
  return api.get('/questions/random');
};

export const checkAnswer = async (id: number, userAnswer: string) => {
  return api.post(`/questions/${id}/check`, null, {
    params: { userAnswer },
  });
};

export const checkAllAnswers = async (userAnswers: { id: number; answer: string }[]) => {
  return api.post('/questions/check-all', userAnswers);
};

export default api;