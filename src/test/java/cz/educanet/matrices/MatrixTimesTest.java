package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixTimesTest {

    @Test
    public void should_Succeed_When_MatricesAreMultiplied() {
        IMatrix matrix1 = MatrixFactory.instance.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        IMatrix matrix2 = MatrixFactory.instance.create(new double[][]{{7, 8}, {9, 10}, {11, 12}});
        IMatrix matrix3 = MatrixFactory.instance.create(new double[][]{{58, 64}, {139, 154}});

        Assertions.assertEquals(matrix3, matrix1.times(matrix2));
    }
    
    @Test
    public void should_Succeed_When_MatrixIsMultipliedByNumber() {
        IMatrix matrix1 = MatrixFactory.instance.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        IMatrix matrix2 = MatrixFactory.instance.create(new double[][]{{2, 4, 6}, {8, 10, 12}});

        Assertions.assertEquals(matrix2, matrix1.times(2));
    }
}