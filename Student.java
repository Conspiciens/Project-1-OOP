public class Student {
    private Boolean correct; 
    private String ID; 
    private String[] answer; 
    private String[] prev; 

    /* Init the Student */
    public Student(String ID){
        this.ID = ID;
    }

    /* Set whether the answer is correct */
    public void setCorrect(Boolean correct){
        this.correct = correct;
    }

    /* Set the answer and previous answer */
    public void setAnswer(String[] answer) {
        if (this.correct != null)
            this.prev = this.answer;
        this.answer = answer; 
    }

    /* Get previous answer */
    public String[] getPrev(){
        return this.prev;
    } 

    /* Get the whether answer is correct*/
    public Boolean getCorrect(){
        return this.correct;
    }

    /* Get the answer from the Student */
    public String[] getAnswer(){
        return this.answer;
    }

    /* Get ID of Student */
    public String getID(){
        return this.ID; 
    }
}
