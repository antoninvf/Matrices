package cz.educanet;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.MatrixFactory;

public class Main {
    public static void main(String[] args) {
        IMatrix matrixCreate = MatrixFactory.instance.create(new double[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
        IMatrix matrixDiagonal = MatrixFactory.instance.createDiagonal(new double[]{1, 1, 1});
        IMatrix matrixIdentity = MatrixFactory.instance.createIdentity(4);

        System.out.println(matrixCreate);
        System.out.println();
        System.out.println(matrixDiagonal);
        System.out.println();
        System.out.println(matrixIdentity);
        System.out.println();

        IMatrix times1 = MatrixFactory.instance.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        IMatrix times2 = MatrixFactory.instance.create(new double[][]{{7, 8}, {9, 10}, {11, 12}});

        System.out.println(times1);
        System.out.println();
        System.out.println(times1.times(times2));
        
        IMatrix add1 = MatrixFactory.instance.create(new double[][]{{3, 8}, {4, 6}});
        IMatrix add2 = MatrixFactory.instance.create(new double[][]{{4, 0}, {1, -9}});
        
        System.out.println(add1);
        System.out.println();
        System.out.println(add1.add(add2));
    }
}