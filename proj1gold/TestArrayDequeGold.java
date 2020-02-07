import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {

        StudentArrayDeque<Integer> stu_test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stu_right = new ArrayDequeSolution<>();

        for (int i = 0; i < 10000; i++) {
            double numberRandom = StdRandom.uniform();
            if (numberRandom < 0.25) {
                stu_test.addFirst(i);
                stu_right.addFirst(i);
            } else if (numberRandom < 0.5) {
                stu_test.addLast(i);
                stu_right.addFirst(i);
            } else if (numberRandom < 0.75) {
                if (!stu_test.isEmpty() && !stu_right.isEmpty()) {
                    Integer a = stu_test.removeFirst();
                    Integer b = stu_right.removeFirst();
                    assertEquals(a, b);
                }
            } else {
                if (!stu_test.isEmpty() && !stu_right.isEmpty()) {
                    Integer a = stu_test.removeLast();
                    Integer b = stu_right.removeLast();
                    assertEquals(a, b);
                }
            }
            while (!stu_test.isEmpty() && !stu_right.isEmpty()) {
                assertEquals(stu_right.removeFirst(), stu_test.removeFirst());
            }
            Assert.assertTrue(stu_test.isEmpty());
            Assert.assertTrue(stu_right.isEmpty());
        }
    }


}
