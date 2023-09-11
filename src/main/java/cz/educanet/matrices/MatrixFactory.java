package cz.educanet.matrices;

import java.util.Arrays;

public class MatrixFactory implements IMatrixFactory {

    public static final IMatrixFactory instance = new MatrixFactory();

    private MatrixFactory() {
    }

    @Override
    public IMatrix create(double[][] data) {
        return new Matrix(data);
    }

    @Override
    public IMatrix createDiagonal(double[] diagonal) {
        double[][] newMatrix = new double[diagonal.length][diagonal.length];
        
        for (int i = 0; i < diagonal.length; i++) {
            newMatrix[i][i] = diagonal[i];
        }
        
        return new Matrix(newMatrix);
    }
    
    @Override
    public IMatrix createIdentity(int size) {
        double[] forDiagonal = new double[size];
        Arrays.fill(forDiagonal, 1);
        
        return createDiagonal(forDiagonal);
    }

    @Override
    public IMatrix createZero(int size) {
        if (size < 0)
            throw new IllegalArgumentException();

        return new Matrix(new double[size][size]);
    }
}
