package com.example.starcatcher_api.config;

import com.example.starcatcher_api.model.Question;
import com.example.starcatcher_api.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class QuestionSeeder {

    private static final Logger logger = LoggerFactory.getLogger(QuestionSeeder.class);

    @Bean
CommandLineRunner seedDatabase(QuestionRepository questionRepository) {
    return args -> {
        String profile = System.getProperty("spring.profiles.active", "default");
        if ("test".equals(profile)) {
            logger.info("Seeder desativado no ambiente de teste.");
            return;
        }

        if (questionRepository.count() == 0) {
                List<Question> questions = List.of(
                        new Question("Qual é o maior planeta do Sistema Solar?", "Júpiter",
                                Arrays.asList("Saturno", "Júpiter", "Marte", "Urano")),
                        new Question("Qual planeta é conhecido como o 'Planeta Vermelho'?", "Marte",
                                Arrays.asList("Vênus", "Marte", "Mercúrio", "Netuno")),
                        new Question("Quantos planetas existem no Sistema Solar?", "8",
                                Arrays.asList("10", "8", "12", "6")),
                        new Question("Qual planeta tem um sistema de anéis notável?", "Saturno",
                                Arrays.asList("Urano", "Netuno", "Saturno", "Terra")),
                        new Question("Qual é o planeta mais próximo do Sol?", "Mercúrio",
                                Arrays.asList("Mercúrio", "Vênus", "Terra", "Marte")),
                        new Question("Qual é o planeta mais distante do Sol no Sistema Solar?", "Netuno",
                                Arrays.asList("Urano", "Netuno", "Plutão", "Saturno")),
                        new Question("Qual planeta é conhecido como o 'Planeta Azul'?", "Terra",
                                Arrays.asList("Urano", "Terra", "Netuno", "Júpiter")),
                        new Question("Qual planeta tem o maior número de luas conhecidas?", "Saturno",
                                Arrays.asList("Saturno", "Urano", "Marte", "Mercúrio")),
                        new Question("Qual planeta leva mais tempo para completar uma órbita ao redor do Sol?",
                                "Netuno",
                                Arrays.asList("Saturno", "Netuno", "Marte", "Vênus")),
                        new Question("Qual planeta tem a atmosfera mais densa e quente do Sistema Solar?",
                                "Vênus",
                                Arrays.asList("Terra", "Júpiter", "Vênus", "Mercúrio")),
                        new Question("Qual é o nome da maior lua de Júpiter?", "Ganimedes",
                                Arrays.asList("Europa", "Io", "Ganimedes", "Titã")),
                        new Question("Qual planeta tem uma lua chamada Titã?", "Saturno",
                                Arrays.asList("Urano", "Saturno", "Marte", "Netuno")),
                        new Question("Qual planeta possui as luas Fobos e Deimos?", "Marte",
                                Arrays.asList("Mercúrio", "Marte", "Júpiter", "Terra")),
                        new Question("Qual é a maior lua do Sistema Solar?", "Ganimedes",
                                Arrays.asList("Ganimedes", "Titã", "Tritão", "Europa")),
                        new Question("Qual é a única lua do Sistema Solar que possui uma atmosfera densa?",
                                "Titã",
                                Arrays.asList("Titânia", "Titã", "Fobos", "Miranda")),
                        new Question("Qual é o nome da lua mais famosa de Netuno?", "Tritão",
                                Arrays.asList("Tritão", "Europa", "Calisto", "Oberon")),
                        new Question("Qual planeta possui a lua chamada Miranda?", "Urano",
                                Arrays.asList("Urano", "Saturno", "Netuno", "Júpiter")),
                        new Question(
                                "Qual lua é conhecida por sua superfície coberta de gelo e possível oceano subterrâneo?",
                                "Europa",
                                Arrays.asList("Europa", "Deimos", "Io", "Tritão")),
                        new Question("Quantas luas possui Mercúrio?", "Nenhuma",
                                Arrays.asList("1", "2", "Nenhuma", "4")),
                        new Question("Qual lua do Sistema Solar possui vulcões ativos?", "Io",
                                Arrays.asList("Io", "Ganimedes", "Titã", "Tritão")),
                        new Question("Qual é a estrela mais próxima da Terra?", "Sol",
                                Arrays.asList("Sirius", "Proxima Centauri", "Sol", "Betelgeuse")),
                        new Question("Qual é a estrela mais brilhante no céu noturno?", "Sirius",
                                Arrays.asList("Polaris", "Sirius", "Rigel", "Alpha Centauri")),
                        new Question("O que é uma supernova?",
                                "A explosão de uma estrela massiva no final de sua vida",
                                Arrays.asList("Uma estrela recém-nascida", "Uma galáxia em colapso",
                                        "A explosão de uma estrela massiva no final de sua vida",
                                        "Um buraco negro em formação")),
                        new Question(
                                "Qual é o nome da estrela que serve como referência para o norte no hemisfério norte?",
                                "Polaris",
                                Arrays.asList("Sirius", "Polaris", "Vega", "Antares")),
                        new Question("Qual é o principal elemento químico que compõe as estrelas?", "Hidrogênio",
                                Arrays.asList("Oxigênio", "Hidrogênio", "Carbono", "Hélio")),
                        new Question("O que determina a cor de uma estrela?", "Sua temperatura",
                                Arrays.asList("Sua composição química", "Sua temperatura", "Sua idade",
                                        "Sua distância da Terra")),
                        new Question("Qual é o estágio final de uma estrela como o Sol?", "Anã branca",
                                Arrays.asList("Buraco negro", "Supernova", "Anã branca", "Estrela de nêutrons")),
                        new Question("O que é uma constelação?",
                                "Um grupo de estrelas que formam um padrão no céu",
                                Arrays.asList("Um grupo de estrelas que formam um padrão no céu",
                                        "Um tipo de galáxia pequena", "Uma estrela com múltiplos planetas",
                                        "Uma explosão estelar")),
                        new Question("Qual é a maior categoria de estrelas em termos de tamanho?",
                                "Estrelas supergigantes",
                                Arrays.asList("Estrelas anãs", "Estrelas supergigantes", "Estrelas de nêutrons",
                                        "Buracos negros")),
                        new Question("O que é uma estrela de nêutrons?",
                                "O núcleo colapsado de uma estrela massiva após uma supernova",
                                Arrays.asList("Uma estrela em formação",
                                        "O núcleo colapsado de uma estrela massiva após uma supernova",
                                        "Uma estrela composta apenas por hidrogênio",
                                        "Uma estrela que nunca entrou em colapso")),
                        new Question("Qual é o nome da galáxia onde está localizado o Sistema Solar?",
                                "Via Láctea",
                                Arrays.asList("Andrômeda", "Via Láctea", "Triângulo", "Sombrero")),
                        new Question("Qual é o formato da Via Láctea?", "Espiral",
                                Arrays.asList("Elíptico", "Espiral", "Irregular", "Circular")),
                        new Question("Qual é a galáxia mais próxima da Via Láctea?", "Andrômeda",
                                Arrays.asList("Galáxia do Triângulo", "Andrômeda", "Centaurus A", "Sombrero")),
                        new Question("O que é um grupo local de galáxias?",
                                "Um grupo de galáxias próximas, incluindo a Via Láctea",
                                Arrays.asList("Um conjunto de estrelas próximas", "Uma região do espaço sem galáxias",
                                        "Um grupo de galáxias próximas, incluindo a Via Láctea",
                                        "Um buraco negro cercado por galáxias")),
                        new Question("Qual é o maior tipo de galáxia conhecido?", "Galáxia elíptica",
                                Arrays.asList("Galáxia espiral", "Galáxia elíptica", "Galáxia irregular",
                                        "Galáxia anã")),
                        new Question("Qual é o nome do buraco negro supermassivo no centro da Via Láctea?",
                                "Sagittarius A*",
                                Arrays.asList("Cygnus X-1", "Sagittarius A*", "Andromeda Core", "Messier 87")),
                        new Question("Qual é a galáxia mais brilhante no céu noturno visível a olho nu?",
                                "Andrômeda",
                                Arrays.asList("Via Láctea", "Andrômeda", "Triângulo", "Centaurus A")),
                        new Question("Como as galáxias são classificadas de acordo com Edwin Hubble?",
                                "Espirais, elípticas e irregulares",
                                Arrays.asList("Espirais, elípticas e irregulares", "Pequenas, médias e grandes",
                                        "Antigas e modernas", "Lentas e rápidas")),
                        new Question("O que é uma galáxia anã?",
                                "Uma galáxia muito pequena em tamanho e número de estrelas",
                                Arrays.asList("Uma galáxia muito pequena em tamanho e número de estrelas",
                                        "Uma galáxia formada apenas por anãs brancas",
                                        "Uma galáxia que orbita outra galáxia maior", "Uma galáxia em colapso")),
                        new Question("Qual é o destino provável da Via Láctea e da galáxia de Andrômeda?",
                                "Elas vão colidir e formar uma nova galáxia",
                                Arrays.asList("Elas vão colidir e formar uma nova galáxia",
                                        "Andrômeda vai engolir a Via Láctea", "Elas vão se afastar para sempre",
                                        "Andrômeda vai explodir antes de chegar à Via Láctea")),
                        new Question("O que é um buraco negro?",
                                "Uma região do espaço onde a gravidade é tão forte que nada, nem a luz, pode escapar",
                                Arrays.asList("Uma estrela muito brilhante",
                                        "Uma região do espaço onde a gravidade é tão forte que nada, nem a luz, pode escapar",
                                        "Um buraco no tecido do espaço causado por meteoros",
                                        "Um túnel para outra dimensão")),
                        new Question(
                                "Qual é o nome da região ao redor de um buraco negro de onde nem a luz pode escapar?",
                                "Horizonte de eventos",
                                Arrays.asList("Horizonte de escape", "Horizonte de eventos", "Núcleo gravitacional",
                                        "Singularidade")),
                        new Question("O que existe no centro de um buraco negro?",
                                "Uma singularidade, onde a densidade é infinita",
                                Arrays.asList("Um vácuo absoluto", "Uma estrela compacta",
                                        "Uma singularidade, onde a densidade é infinita",
                                        "Um portal para outro universo")),
                        new Question("Qual é o nome do buraco negro supermassivo no centro da Via Láctea?",
                                "Sagittarius A*",
                                Arrays.asList("Cygnus X-1", "Sagittarius A*", "Andromeda Core", "Messier 87")),
                        new Question("Como os buracos negros se formam?",
                                "Pela explosão de uma estrela massiva no final de sua vida",
                                Arrays.asList("Pela fusão de duas estrelas gigantes",
                                        "Pela explosão de uma estrela massiva no final de sua vida",
                                        "Pelo colapso de um planeta gigante", "Por colisões entre galáxias")),
                        new Question("O que é um buraco negro supermassivo?",
                                "Um buraco negro que contém a massa de milhões ou bilhões de sóis",
                                Arrays.asList("Um buraco negro que contém a massa de milhões ou bilhões de sóis",
                                        "Um buraco negro que consome estrelas diariamente",
                                        "Um buraco negro que está se expandindo rapidamente",
                                        "Um buraco negro que já deixou de existir")),
                        new Question("O que é a radiação de Hawking?",
                                "A radiação teórica emitida por buracos negros devido a efeitos quânticos",
                                Arrays.asList("A luz emitida por buracos negros",
                                        "A energia liberada quando um buraco negro explode",
                                        "A radiação teórica emitida por buracos negros devido a efeitos quânticos",
                                        "A radiação emitida por estrelas próximas a buracos negros")),
                        new Question("É possível 'ver' um buraco negro diretamente?",
                                "Não, porque eles não emitem luz",
                                Arrays.asList("Sim, com telescópios potentes", "Não, porque eles não emitem luz",
                                        "Sim, porque eles brilham intensamente no espaço",
                                        "Não, porque eles estão escondidos por gás e poeira")),
                        new Question("O que acontece com o tempo ao se aproximar de um buraco negro?",
                                "Ele se move mais devagar devido à gravidade extrema",
                                Arrays.asList("Ele acelera", "Ele para completamente",
                                        "Ele se move mais devagar devido à gravidade extrema",
                                        "Ele se torna imprevisível")),
                        new Question("Qual foi o nome da primeira imagem de um buraco negro capturada em 2019?",
                                "M87*",
                                Arrays.asList("Buraco Negro de Andrômeda", "M87*", "Sagittarius A*",
                                        "Horizonte de Eventos 1")));
                questionRepository.saveAll(questions); // Salva as perguntas
                logger.info("Banco de dados inicializado com perguntas pré-definidas.");
            } else {
                logger.info("Banco de dados já contém perguntas. Nenhuma ação realizada.");
            }
        };
    }
}