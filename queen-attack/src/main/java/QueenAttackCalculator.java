import java.util.Objects;

class QueenAttackCalculator {
    private final Queen queen1;
    private final Queen queen2;

    QueenAttackCalculator(Queen queen1, Queen queen2) throws IllegalArgumentException {
        if (Objects.isNull(queen1) || Objects.isNull(queen2)) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (queen1.getRow() == queen2.getRow() && queen1.getColumn() == queen2.getColumn()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    boolean canQueensAttackOneAnother() {
        boolean isEqualRow = queen1.getRow() == queen2.getRow();
        boolean isEqualColumn = queen1.getColumn() == queen2.getColumn();
        boolean isSameDiagonal = Math.abs(queen2.getRow() - queen1.getRow()) == Math.abs(queen2.getColumn() - queen1.getColumn());
        return isEqualRow || isEqualColumn || isSameDiagonal;
    }
}