package BitManipulation.Easy;

//So always left shift when checking the i-th bit.
public class CheckIthBit {
    public boolean checkIthBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}