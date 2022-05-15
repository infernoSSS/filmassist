package com.filmassist.filmassist.tasks;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuestionTreeConfigurator {
    public Question configuration(){
        String[] partySize = {"Одиночество...", "Нас тут двое", "Party!!!"};
        String[] age = {"<12", "12..18", "18..25", ">25"};
        String[] prefer = {"посмеяться", "погрустить", "экшон!!!", "на фон", "подумат..."};
        String[] producers = {"западные", "восточные", "отчественные"};
        String[] filmsWatched = {"<100", "100..500", ">500"};


        Map<String, Question> questionsList = questionsList();
        for(String a : partySize){
            questionsList.get("r").add(new Answer(a, new Question(questionsList.get("r1|2|3"))));
        }
        Question r1 = questionsList.get("r").getNextQuestByAnswer(1);
        r1.add(new Answer(age[0], new Question(questionsList.get("r11"))));
        for(int i = 1; i<age.length; i++){
            r1.add(new Answer(age[i], new Question(questionsList.get("r12|3|4"))));
        }
        Question r2 = questionsList.get("r").getNextQuestByAnswer(2);
        for(String a : age){
            r2.add(new Answer(a, new Question(questionsList.get("(r2|3)|(r12|3|41|2|3)"))));
        }
        Question r3 = questionsList.get("r").getNextQuestByAnswer(3);
        for(String a : age){
            r3.add(new Answer(a, new Question(questionsList.get("(r2|3)|(r12|3|41|2|3)"))));
        }

        Question r11 = r1.getNextQuestByAnswer(1);
        for(String a : producers){
            r11.add(new Answer(a, null));
        }
//        Question r111 = r11.getNextQuestByAnswer(1);
//        Question r112 = r11.getNextQuestByAnswer(2);
//        Question r113 = r11.getNextQuestByAnswer(3);
        Question r12 =r1.getNextQuestByAnswer(2);
        for(String a : filmsWatched){
            r12.add(new Answer(a, new Question(questionsList.get("r12|3|4"))));
        }
        Question r121 =r12.getNextQuestByAnswer(1);
        for(String a : prefer){
            r121.add(new Answer(a, null));
        }
//        Question r1211 =r121.getNextQuestByAnswer(1);
//        Question r1212 =r121.getNextQuestByAnswer(2);
//        Question r1213 =r121.getNextQuestByAnswer(3);
//        Question r1214 =r121.getNextQuestByAnswer(4);
//        Question r1215 =r121.getNextQuestByAnswer(5);
        Question r122 =r12.getNextQuestByAnswer(2);
        for(String a : prefer){
            r122.add(new Answer(a, null));
        }
//        Question r1221 =r122.getNextQuestByAnswer(1);
//        Question r1222 =r122.getNextQuestByAnswer(2);
//        Question r1223 =r122.getNextQuestByAnswer(3);
//        Question r1224 =r122.getNextQuestByAnswer(4);
//        Question r1225 =r122.getNextQuestByAnswer(5);
        Question r123 =r12.getNextQuestByAnswer(3);
        for(String a : prefer){
            r123.add(new Answer(a, null));
        }
//        Question r1231 =r123.getNextQuestByAnswer(1);
//        Question r1232 =r123.getNextQuestByAnswer(2);
//        Question r1233 =r123.getNextQuestByAnswer(3);
//        Question r1234 =r123.getNextQuestByAnswer(4);
//        Question r1235 =r123.getNextQuestByAnswer(5);
        Question r13 =r1.getNextQuestByAnswer(3);
        for(String a : filmsWatched){
            r13.add(new Answer(a, new Question(questionsList.get("r12|3|4"))));
        }
        Question r131 =r13.getNextQuestByAnswer(1);
        for(String a : prefer){
            r131.add(new Answer(a, null));
        }
//        Question r1311 =r131.getNextQuestByAnswer(1);
//        Question r1312 =r131.getNextQuestByAnswer(2);
//        Question r1313 =r131.getNextQuestByAnswer(3);
//        Question r1314 =r131.getNextQuestByAnswer(4);
//        Question r1315 =r131.getNextQuestByAnswer(5);
        Question r132 =r13.getNextQuestByAnswer(2);
        for(String a : prefer){
            r132.add(new Answer(a, null));
        }
//        Question r1321 =r132.getNextQuestByAnswer(1);
//        Question r1322 =r132.getNextQuestByAnswer(2);
//        Question r1323 =r132.getNextQuestByAnswer(3);
//        Question r1324 =r132.getNextQuestByAnswer(4);
//        Question r1325 =r132.getNextQuestByAnswer(5);
        Question r133 =r13.getNextQuestByAnswer(3);
        for(String a : prefer){
            r133.add(new Answer(a, null));
        }
//        Question r1331 =r133.getNextQuestByAnswer(1);
//        Question r1332 =r133.getNextQuestByAnswer(2);
//        Question r1333 =r133.getNextQuestByAnswer(3);
//        Question r1334 =r133.getNextQuestByAnswer(4);
//        Question r1335 =r133.getNextQuestByAnswer(5);
        Question r14 =r1.getNextQuestByAnswer(4);
        for(String a : filmsWatched){
            r14.add(new Answer(a, new Question(questionsList.get("r12|3|4"))));
        }
        Question r141 =r14.getNextQuestByAnswer(1);
        for(String a : prefer){
            r141.add(new Answer(a, null));
        }
//        Question r1411 =r141.getNextQuestByAnswer(1);
//        Question r1412 =r141.getNextQuestByAnswer(2);
//        Question r1413 =r141.getNextQuestByAnswer(3);
//        Question r1414 =r141.getNextQuestByAnswer(4);
//        Question r1415 =r141.getNextQuestByAnswer(5);
        Question r142 =r14.getNextQuestByAnswer(2);
        for(String a : prefer){
            r142.add(new Answer(a, null));
        }
//        Question r1421 =r142.getNextQuestByAnswer(1);
//        Question r1422 =r142.getNextQuestByAnswer(2);
//        Question r1423 =r142.getNextQuestByAnswer(3);
//        Question r1424 =r142.getNextQuestByAnswer(4);
//        Question r1425 =r142.getNextQuestByAnswer(5);
        Question r143 =r14.getNextQuestByAnswer(3);
        for(String a : prefer){
            r143.add(new Answer(a, null));
        }
//        Question r1431 =r143.getNextQuestByAnswer(1);
//        Question r1432 =r143.getNextQuestByAnswer(2);
//        Question r1433 =r143.getNextQuestByAnswer(3);
//        Question r1434 =r143.getNextQuestByAnswer(4);
//        Question r1435 =r143.getNextQuestByAnswer(5);

        Question r21 = r2.getNextQuestByAnswer(1);
        for(String a : prefer){
            r21.add(new Answer(a, null));
        }
//        Question r211 = r21.getNextQuestByAnswer(1);
//        Question r212 = r21.getNextQuestByAnswer(2);
//        Question r213 = r21.getNextQuestByAnswer(3);
//        Question r214 = r21.getNextQuestByAnswer(4);
//        Question r215 = r21.getNextQuestByAnswer(5);
        Question r22 = r2.getNextQuestByAnswer(2);
        for(String a : prefer){
            r22.add(new Answer(a, null));
        }
//        Question r221 = r22.getNextQuestByAnswer(1);
//        Question r222 = r22.getNextQuestByAnswer(2);
//        Question r223 = r22.getNextQuestByAnswer(3);
//        Question r224 = r22.getNextQuestByAnswer(4);
//        Question r225 = r22.getNextQuestByAnswer(5);
        Question r23 = r2.getNextQuestByAnswer(3);
        for(String a : prefer){
            r23.add(new Answer(a, null));
        }
//        Question r231 = r23.getNextQuestByAnswer(1);
//        Question r232 = r23.getNextQuestByAnswer(2);
//        Question r233 = r23.getNextQuestByAnswer(3);
//        Question r234 = r23.getNextQuestByAnswer(4);
//        Question r235 = r23.getNextQuestByAnswer(5);
        Question r24 = r2.getNextQuestByAnswer(4);
        for(String a : prefer){
            r24.add(new Answer(a, null));
        }
//        Question r241 = r24.getNextQuestByAnswer(1);
//        Question r242 = r24.getNextQuestByAnswer(2);
//        Question r243 = r24.getNextQuestByAnswer(3);
//        Question r244 = r24.getNextQuestByAnswer(4);
//        Question r245 = r24.getNextQuestByAnswer(5);

        Question r31 = r3.getNextQuestByAnswer(1);
        for(String a : prefer){
            r31.add(new Answer(a, null));
        }
//        Question r311 = r31.getNextQuestByAnswer(1);
//        Question r312 = r31.getNextQuestByAnswer(2);
//        Question r313 = r31.getNextQuestByAnswer(3);
//        Question r314 = r31.getNextQuestByAnswer(4);
//        Question r315 = r31.getNextQuestByAnswer(5);
        Question r32 = r3.getNextQuestByAnswer(2);
        for(String a : prefer){
            r32.add(new Answer(a, null));
        }
//        Question r321 = r32.getNextQuestByAnswer(1);
//        Question r322 = r32.getNextQuestByAnswer(2);
//        Question r323 = r32.getNextQuestByAnswer(3);
//        Question r324 = r32.getNextQuestByAnswer(4);
//        Question r325 = r32.getNextQuestByAnswer(5);
        Question r33 = r3.getNextQuestByAnswer(3);
        for(String a : prefer){
            r33.add(new Answer(a, null));
        }
//        Question r331 = r33.getNextQuestByAnswer(1);
//        Question r332 = r33.getNextQuestByAnswer(2);
//        Question r333 = r33.getNextQuestByAnswer(3);
//        Question r334 = r33.getNextQuestByAnswer(4);
//        Question r335 = r33.getNextQuestByAnswer(5);
        Question r34 = r3.getNextQuestByAnswer(4);
        for(String a : prefer){
            r34.add(new Answer(a, null));
        }
//        Question r341 = r34.getNextQuestByAnswer(1);
//        Question r342 = r34.getNextQuestByAnswer(2);
//        Question r343 = r34.getNextQuestByAnswer(3);
//        Question r344 = r34.getNextQuestByAnswer(4);
//        Question r345 = r34.getNextQuestByAnswer(5);
        return questionsList.get("r");
    }

    public Map<String, Question> questionsList(){
        Map<String, Question> questionsList = new HashMap<>();
        questionsList.put("r", new Question("Хотите посмотреть фильм одни или в компании?"));
        questionsList.put("r1|2|3", new Question("На сколько вы стары?"));
        questionsList.put("(r2|3)|(r12|3|41|2|3)", new Question("Чего вам хочется?"));
        questionsList.put("r11", new Question("Какие вам больше нравятся фильмы?"));
        questionsList.put("r12|3|4", new Question("Как много фильмов вы уже посмотрели?"));
        return questionsList;
    }
}
