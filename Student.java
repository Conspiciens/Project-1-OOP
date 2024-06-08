public class Student {
    private String ID; 
    private String[] answer; 

    /* Init the Student */
    public Student(String ID){
        this.ID = ID;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer; 
    }

    public String[] getAnswer(){
        return answer;
    }

    public String getID(){
        return this.ID; 
    }
}
