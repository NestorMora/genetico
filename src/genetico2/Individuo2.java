
package genetico2;

public class Individuo2 implements Comparable<Individuo2>{
    public String genomaBinario;
    public int genomaInt;
    public double fitnes;
    
    public Individuo2(){
        this.genomaBinario=genomaBinario;
        this.fitnes=fitnes;
        this.genomaInt=genomaInt;
    }

    public String getGenomaBinario() {
        return genomaBinario;
    }

    public void setGenomaBinario(String genomaBinario) {
        this.genomaBinario = genomaBinario;
    }

    public int getGenomaInt() {
        return genomaInt;
    }

    public void setGenomaInt(int genomaInt) {
        this.genomaInt = genomaInt;
    }

    public double getFitnes() {
        return fitnes;
    }

    public void setFitnes(double fitnes) {
        this.fitnes = fitnes;
    }
    
    
     public String toString(){
        StringBuilder sb = new StringBuilder();                                                                   
        sb.append("\ngenoma en entero: ");
        sb.append(genomaInt);
        sb.append("\ngenoma en binario: ");
        sb.append(genomaBinario);
        sb.append("\nfitness: ");
        sb.append(fitnes);
        return sb.toString();
    }

    public int compareTo(Individuo2 e){
        if(e.getFitnes()<fitnes){
            return -1;
        }else if(e.getFitnes()==fitnes){
            return 0;
        }else{
            return 1;
        }
    }
}
