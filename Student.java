public class Student {
    private Boolean correct; 
    private String ID; 
    private String[] answer; 
    private String[] prev; 

    /* Init the Student */
    public Student(String ID){
        this.ID = ID;
    }

    public void setCorrect(Boolean correct){
        this.correct = correct;
    }

    public void setAnswer(String[] answer) {
        if (this.correct != null)
            this.prev = this.answer;
        this.answer = answer; 
    }

    public String[] getPrev(){
        return this.prev;
    } 

    public Boolean getCorrect(){
        return this.correct;
    }

    public String[] getAnswer(){
        return this.answer;
    }

    public String getID(){
        return this.ID; 
    }
}
