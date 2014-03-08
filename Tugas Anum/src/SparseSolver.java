import java.util.LinkedList;

/**
 * Class ini digunakan untuk menyelesaikan persamaan Ax = b dimana A adalah matriks sparse
 * menggunakan Gaussian LU
 * 
 * @author Febriana Wulan Sari
 *
 */
public class SparseSolver {
	public LinkedList<Double> matrixL;
	public LinkedList<Integer> indexL;
	public LinkedList<Double> matrixU;
	public LinkedList<Integer> indexU;
	public LinkedList<Double> sparseMatrixA;
	public LinkedList<Integer> indexA;
	public int n = 0;
	
	public static void main(String[] a) {
	
	}
	
	/**
	 * Contructor
	 */
	public SparseSolver() {
		matrixL = new LinkedList<Double>();
		indexL = new LinkedList<Integer>();
		matrixU = new LinkedList<Double>();
		indexU = new LinkedList<Integer>();
		sparseMatrixA = new LinkedList<Double>();
		indexA = new LinkedList<Integer>();		
	}
	
	/**
	 * method ini digunakan untuk menyelesaikan persamaan Ax = b
	 * @param matriks A
	 * @param matriks b
	 * @return matriks x
	 */
	public double[] hitungLU(double[][] A, double[] b) {
		this.n = A.length;
		sparseMatriksA(A);
		//LUFactorization(matriksA);
		//double[] y = forwardElimination(b);
		//backwardSubstitution(y);
		return null;
	}
	
	/**
	 * method ini digunakan  untuk mengubah representasi matriks sparse A
	 * @param matriks A yang akan diubah representasinya
	 */
	public void sparseMatriksA(double[][] A) {
		int length = A.length;
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				if(A[i][j] != 0) {
					this.sparseMatrixA.add(A[i][j]);
					this.indexA.add((i * length) + j);
				}
			}
		}
	}
	
	public void tukarBaris(LinkedList<Double> A) {
		
	}
	
	/**
	 * method ini digunakan untuk melakukan faktorisasi LU menggunakan pivoting
	 */
	public void LUFactorization() {
		LinkedList<Double> M = new LinkedList<Double>();
		LinkedList<Integer> indexM = new LinkedList<Integer>();
		
		// copy A ke M
		for(int i = 0; i < this.sparseMatrixA.size(); i++) {
			M.add(this.sparseMatrixA.get(i));
			indexM.add(this.indexA.get(i));
		}
		
		LinkedList<Double> P = new LinkedList<Double>();
		LinkedList<Integer> indexP = new LinkedList<Integer>();
		
		for(int i = 0; i < this.n; i++) {
			P.add(1.0);
			indexP.add(i * this.n + i);
		}
		
		LinkedList<Double> L = new LinkedList<Double>();
		LinkedList<Integer> indexL = new LinkedList<Integer>();
		
		for(int i = 0; i < this.n; i++) {
			L.add(1.0);
			indexL.add(i * this.n + i);
		}
		
		// m = A
		// p = eye(n)
		// L = p
		
		
		// for i=0:n-1
		
		for(int i = 0; i < this.n; i++) {
			// pivotIndex = i
			int pivotIndex = i;
			// pivotValue = Math.abs(m(i,i)
			double pivotValue = 0;
			int j = 0;
			while(j < M.size()) {
				if(indexM.get(j) == (i * this.n + i)) {
					pivotValue = Math.abs(M.get(j));
					break;
				}
			}
			// for j=i+1:n
			for(int k = i + 1; k < this.n; k++) {
				if(j == M.size()) j = 0;
				while(j < M.size()) {
					if(indexM.get(j) == (j * this.n + i)) {
						double tmp = Math.abs(M.get(j));
						if(tmp > pivotValue) {
							pivotValue = tmp;
							pivotIndex = j;
						}
						break;
					}
				}
				
				// if Math.abs(m(j,i)) > pivotValue
					// pivotIndex = j
					// pivotValue = Math.abs(m(j,i))
				// end if
			// end for
			}
			// if pivotIndex > i --> jika perlu ditukar
			if(pivotIndex > i) {
				// tukar baris-baris m
				// tukar baris-baris L juga
				// tukar baris-baris p
			// end if
			}
			if(pivotValue != 0) {
				// for j=i+1:n
				for(int k = i + i; k < this.n; k++) {
					// L(j,i) = m(j,i)/m(i,i)
					
					// for k=i+1:n
						// m(j,k) = m(j,k) - L(j,i) * m(j, i)
					// end for
				// end for
				}
			}
		// end for
		}
		// this.matrixL = L
		// this.matrixU = M
	}
	
	/**
	 * method ini digunakan untuk menyelesaikan persamaan Ly = b
	 * @param matriks b
	 * @return matriks y
	 */
	public double[] forwardElimination(double[] b) {
		
		return null;
	}
	
	/**
	 * method ini digunakan untuk menyelesaikan persamaan Ux = y
	 * @param matriks y
	 * @return matriks x
	 */
	public double[] backwardSubstitution(double[] y) {
		
		return null;
	}
}
