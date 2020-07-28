package support;



public class RangeNode{
    int leftBound, rightBound;
    public RangeNode next;

    public RangeNode(int leftBound, int rightBound){
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        next = null;
    }
}
