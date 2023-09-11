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
    }
}