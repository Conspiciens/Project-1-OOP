public interface Question {
    public void setAnswers(String answers[]); 
    public Boolean isCorrect(String vote[]); 
    public void getCorrect(); 
    public void clearCorrect(Boolean clearCorrect);
}

class multiQuestion implements Question {
    String answers[];
    Integer correct = 0; 
    Integer incorrect = 0; 
    public void setAnswers(String answers[]){
       this.answers = answers; 
    }

    public Boolean isCorrect(String vote[]){
        if (vote.length != answers.length){
            incorrect++; 
            return false; 
        }

        int correctOption = 0;
        for (int i = 0; i < vote.length; i++){
            for (int j = 0; j < answers.length; j++){
                if (vote[i] == answers[j]){
                    correctOption++; 
                    continue;
                }
            }
        }

        if (correctOption != answers.length){
            incorrect++;
            return false; 
        }


        correct++; 
        return true;  
    }

    public void clearCorrect(Boolean clearCorrect){
        if (clearCorrect){
            correct--; 
            return;
        }

        incorrect--; 
    }

    public void getCorrect(){
        System.out.println("Right: " + correct + "\n" + 
            "Wrong: " + incorrect);
    }
}

class singleQuestion implements Question {
    String answer; 
    Integer correct = 0; 
    Integer incorrect = 0; 
    public void setAnswers(String answers[]){
        this.answer = answers[0];
    }

    /* Check whether the answer to the question is correct */
    public Boolean isCorrect(String vote[]){
        if (answer == vote[0]){ 
            correct++; 
            return true; 
        }
        incorrect++; 
        return false; 
    }

    public void clearCorrect(Boolean clearCorrect){
        if (clearCorrect){
            correct--; 
            return;
        }

        incorrect--; 
    }

    public void getCorrect(){
        System.out.println("1. Right: " + correct + "\n" 
            + "2. Wrong: " + incorrect);
    }
}
