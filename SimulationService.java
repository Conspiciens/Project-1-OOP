

public class SimulationService {
    public static void main(String[] args){
        String correctAnswers[] = {"A", "B", "C"};
        multiQuestion ques = new multiQuestion();

        ques.setAnswers(correctAnswers);
        VotingService vote = new multiChoice(ques);

        Student stud3 = new Student("323221");
        Student stud4 = new Student("3232321");

        String stud3Ans[] = {"C", "D"}; 
        stud3.setAnswer(stud3Ans);

        String stud4Ans[] = {"A", "B", "C"};
        stud4.setAnswer(stud4Ans);

        vote.voting(stud3);
        vote.voting(stud4);

        String stud4Ans2[] = {"A"}; 
        stud4.setAnswer(stud4Ans2);

        vote.voting(stud4);
    
        vote.printResults();


        String correctAnswers2[] = {"B"};
        singleQuestion ques2 = new singleQuestion();

        Student stud1 = new Student("23231");
        Student stud2 = new Student("23212");

        ques2.setAnswers(correctAnswers2);
        VotingService vote1 = new singleChoice(ques2);

        String stud1Ans[] = {"C"};
        stud1.setAnswer(stud1Ans);

        String stud2Ans[] = {"B"}; 
        stud2.setAnswer(stud2Ans);

        vote1.voting(stud1);
        vote1.voting(stud2);
            
        vote1.printResults();
         
    }
}
