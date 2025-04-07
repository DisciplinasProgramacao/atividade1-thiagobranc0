import java.util.Comparator;

public class ComparadorPorValorComDesempate implements Comparator<Produto> {
    @Override
    public int compare(Produto o1, Produto o2) {
        int resposta = 0;

        if (o1.valorDeVenda() != o2.valorDeVenda()) {
            resposta = (o1.valorDeVenda() > o2.valorDeVenda() ? 1 : -1);
        } else {
            resposta = o1.compareTo(o2);
        }

        return resposta;
    }
}
