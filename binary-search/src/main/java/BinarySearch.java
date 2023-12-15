import java.util.List;

class BinarySearch {
    private List<Integer> items;
    private int delta;

    BinarySearch(List<Integer> items) {
        this.items = items;
    }

    int indexOf(int item) throws ValueNotFoundException {
        var length = items.size();
        if (length == 0) {
            throw new ValueNotFoundException("Value not in array");
        }
        var middleIndex = items.size() / 2;
        if (items.get(middleIndex) == item) {
            return middleIndex + delta;
        } else if (items.get(middleIndex) > item) {
            items = items.subList(0, middleIndex);
            return indexOf(item);
        } else {
            items = items.subList(middleIndex + 1, length);
            delta += middleIndex + 1;
            return indexOf(item);
        }
    }
}

//public int indexOf(int target) throws ValueNotFoundException {
//    int leftPointer = 0;
//    int rightPointer = list.size() - 1;
//    while(leftPointer <= rightPointer) {
//        int middlePointer = ((rightPointer - leftPointer) / 2) + leftPointer;
//        int numInMiddle = list.get(middlePointer);
//        if (numInMiddle == target)
//            return middlePointer;
//        else if (target > numInMiddle)
//            leftPointer = middlePointer + 1;
//        else
//            rightPointer = middlePointer - 1;
//    }
//    throw new ValueNotFoundException("Value not in array");
//}