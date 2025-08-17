package BitManipulation.Easy;

public class SwapTwoNo {
    public int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        int[] result = {a,b};
        return result;
    }
}
