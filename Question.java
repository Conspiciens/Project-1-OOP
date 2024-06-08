public interface Question {
    public void setAnswers(String answers[]); 
    public void isCorrect(String vote[]); 
    public void getCorrect(); 
}

class multiQuestion implements Question {
    String answers[];
    Integer correct = 0; 
    Integer incorrect = 0; 
    public void setAnswers(String answers[]){
       this.answers = answers; 
    }

    public void isCorrect(String vote[]){
        if (vote.length != answers.length){
            incorrect++; 
            return; 
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
            return; 
        }

        correct++; 
        return; 
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
    public void isCorrect(String vote[]){
        if (answer == vote[0]){ 
            correct++; 
            return; 
        }
        incorrect++; 
    }

    public void getCorrect(){
        System.out.println("1. Right: " + correct + "\n" 
            + "2. Wrong: " + incorrect);
    }
}
