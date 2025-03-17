import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Bubblesort<T extends Comparable<T>> implements IOrdenador<T>{
    private long comparacoes;
    private long movimentacoes;
    LocalDateTime inicio, fim;
    @Override
    public T[] ordenar(T[] dados) {
        T[] copiaDados = Arrays.copyOf(dados, dados.length);
        int tamanho = copiaDados.length;
        comparacoes = movimentacoes = 0;
        inicio = LocalDateTime.now();
        for (int posReferencia = tamanho - 1; posReferencia > 0;posReferencia--){
            comparacoes++;
            for(int posicao = 0; posicao < posReferencia; posicao++){
                if (copiaDados[posicao].compareTo(dados[posicao + 1]) > 0){
                    trocar(posicao, posicao + 1, copiaDados);
                }
            }
        }
        fim = LocalDateTime.now();
        return copiaDados;
    }

    private void trocar(int pos1, int pos2, T[] dados) {
        T temp = dados[pos1];
        dados[pos1] = dados[pos2];
        dados[pos2] = temp;
        movimentacoes += 3;
    }

    @Override
    public long getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public double getTempoOrdenacao() {
        return Duration.between(inicio, fim).toMillis();
    }

    @Override
    public long getComparacoes() {
        return comparacoes;
    }
}
