package support;

public class RangeStack {

    private RangeNode first;
    private int size;

    public RangeStack(){
        first = null;
        size = 0;
    }

    public int[] pop() {
        if(first == null){
            return null;
        }
        int leftBound = first.leftBound;
        int rightBound = first.rightBound;
        int[] range = {leftBound, rightBound};
        first = first.next;

        return range;
    }

    public void push(int leftBound, int rightBound) {
        RangeNode nrn = new RangeNode(leftBound, rightBound);
        if(first == null){
            first = nrn;
        }
        else {
            nrn.next = first;
            first = nrn;
        }
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
