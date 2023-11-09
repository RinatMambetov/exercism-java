import java.util.ArrayList;
import java.util.List;

class Dominoes {

    List<Domino> formChain(List<Domino> inputDominoes) throws ChainNotFoundException {
        if (inputDominoes.isEmpty()) {
            return inputDominoes;
        }
        if (inputDominoes.size() == 1 && inputDominoes.get(0).getLeft() == inputDominoes.get(0).getRight()) {
            return inputDominoes;
        }
        if (inputDominoes.size() == 1 && inputDominoes.get(0).getLeft() != inputDominoes.get(0).getRight()) {
            throw new ChainNotFoundException("No domino chain found.");
        }

        List<Domino> tempList = new ArrayList<>(inputDominoes);
        List<Domino> resultList = new ArrayList<>();
        resultList.add(tempList.remove(0));
        int leftNum = resultList.get(0).getLeft();
        int rightNum;

        rightNum = getRightNum(tempList, resultList);

        if (!tempList.isEmpty()) {
            while (resultList.size() != 1) {
                tempList.add(resultList.remove(resultList.size() - 1));
            }
            rightNum = getRightNum(tempList, resultList);
        }

        if (!tempList.isEmpty()) {
            throw new ChainNotFoundException("No domino chain found.");
        }
        if (leftNum != rightNum) {
            throw new ChainNotFoundException("No domino chain found.");
        }
        return resultList;
    }

    private static boolean containNum(Domino domino, int num) {
        return domino.getRight() == num || domino.getLeft() == num;
    }

    private static Domino getReverseDomino(Domino domino) {
        return new Domino(domino.getRight(), domino.getLeft());
    }

    private static int getRightNum(List<Domino> tempList, List<Domino> resultList) {
        int rightNum = resultList.get(0).getRight();
        int size = tempList.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < tempList.size(); j++) {
                if (containNum(tempList.get(j), rightNum)) {
                    if (tempList.get(j).getLeft() == rightNum) {
                        resultList.add(tempList.get(j));
                    } else {
                        resultList.add(getReverseDomino(tempList.get(j)));
                    }
                    tempList.remove(j);
                    rightNum = resultList.get(resultList.size() - 1).getRight();
                    break;
                }
            }
        }
        return rightNum;
    }
}