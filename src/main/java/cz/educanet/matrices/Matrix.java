package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (this.getColumns() != matrix.getRows())
            throw new IllegalArgumentException();

        double[][] newMatrix = new double[this.getRows()][matrix.getColumns()];

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < matrix.getRows(); k++) {
                    newMatrix[i][j] += this.get(i, k) * matrix.get(k, j);
                }
            }
        }

        return MatrixFactory.instance.create(newMatrix);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] newMatrix = this.rawArray;
        newMatrix[0][0] = this.get(0, 0) * scalar.doubleValue();
        return MatrixFactory.instance.create(newMatrix);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] newMatrix = new double[this.getRows()][matrix.getColumns()];

        if (this.getColumns() != matrix.getColumns() || this.getRows() != matrix.getRows())
            throw new IllegalArgumentException();

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                newMatrix[i][j] = this.get(i, j) + matrix.get(i, j);
            }
        }

        return MatrixFactory.instance.create(newMatrix);
    }

    @Override
    public IMatrix transpose() {
        double[][] newArray = new double[this.getColumns()][this.getRows()]; // flipped rows and columns count

        for (int i = 0; i < this.getColumns(); i++) {
            for (int j = 0; j < this.getRows(); j++) {
                newArray[i][j] = this.get(j, i);
            }
        }

        return MatrixFactory.instance.create(newArray);
    }

    @Override
    public double determinant() {
        return 0;
    }

    @Override
    public boolean isSquare() {
        return this.getRows() == this.getColumns();
    }

    @Override
    public boolean isDiagonal() {
        if (!this.isSquare()) return false;

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (i != j && this.get(i, j) != 0) return false;
            }
        }

        return true;
    }

    @Override
    public Number getTrace() {
        if (!this.isSquare()) throw new IllegalArgumentException();

        double trace = 0;
        for (int i = 0; i < this.getRows(); i++) {
            trace += this.get(i, i);
        }

        return trace;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < this.rawArray.length; i++) {
            for (int j = 0; j < this.rawArray[i].length; j++) {
                out.append("[" + this.rawArray[i][j] + "] ");
            }
            if (i != this.rawArray.length - 1) out.append("\n");
        }

        return out.toString();
    }
}
