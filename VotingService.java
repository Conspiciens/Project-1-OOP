import java.util.HashMap;

abstract class VotingService {
    HashMap<String, String[]> votingMap = new HashMap<>(); 
    HashMap<String, Integer> votingCount = new HashMap<>();

    abstract void voting(Student curStudent); 
    abstract void printResults();
}


class singleChoice extends VotingService {
    Question question; 
    
    public singleChoice(Question ques) {
        this.question = ques; 
        votingCount.put("A", 0); 
        votingCount.put("B", 0); 
        votingCount.put("C", 0); 
        votingCount.put("D", 0); 
    }

    void voting(Student currStudent){
        String id = currStudent.getID();
        if (votingMap.containsKey(id)){
            votingMap.remove(id); 
        }

        String singleVote = currStudent.getAnswer()[0];
        
        votingMap.put(id, currStudent.getAnswer()); 
        Boolean isCorrect = question.isCorrect(currStudent.getAnswer());
        currStudent.setCorrect(isCorrect);

        /* Manages the voting count for each letter  */
        if (votingCount.containsKey(singleVote)){
            votingCount.put(singleVote, votingCount.get(singleVote) + 1);
            return; 
        }
        votingCount.put(singleVote, 1); 
    }

    void printResults() {
        votingCount.forEach((key, value) -> {
            System.out.print(key + ": " + value + "\n"); 
        });
        question.getCorrect();
    }
}

class multiChoice extends VotingService {
    Question question; 

    public multiChoice(Question ques) {
        this.question = ques; 
        votingCount.put("A", 0); 
        votingCount.put("B", 0); 
        votingCount.put("C", 0); 
        votingCount.put("D", 0); 
    }
    void voting(Student currStudent){
        String id = currStudent.getID(); 

        if (votingMap.containsKey(id)){
            votingMap.remove(id);

            /* Clear the correction from the count */
            Boolean correct = currStudent.getCorrect();
            question.clearCorrect(correct);

            /* Clear the voting count */
            for (int i = 0; i < currStudent.getPrev().length; i++){
                votingCount.put(currStudent.getPrev()[i], votingCount.get(currStudent.getPrev()[i]) - 1); 
            }
        }

        /* Get the current Voting Map */
        votingMap.put(id, currStudent.getAnswer());
        
        /* Check if correct */
        Boolean isCorrect = question.isCorrect(currStudent.getAnswer());
        currStudent.setCorrect(isCorrect);

        for (int i = 0; i < currStudent.getAnswer().length; i++) {
            if (votingCount.containsKey(currStudent.getAnswer()[i])){
                votingCount.put(currStudent.getAnswer()[i], votingCount.get(currStudent.getAnswer()[i]) + 1);
                continue; 
            }
            votingCount.put(currStudent.getAnswer()[i], 1); 
        }
    }
    
    void printResults() {
        votingCount.forEach((key, value) -> {
            System.out.print(key + ": " + value + "\n"); 
        });
        question.getCorrect();
    }
}