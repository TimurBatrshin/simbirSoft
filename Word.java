import lombok.Data;


@Data

public class Word implements Comparable<Word> {
    String word;
    int count;

    @Override
    public int compareTo(Word b) { return b.count - count; }
}
