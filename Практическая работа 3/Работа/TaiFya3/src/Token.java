public class Token {
    public TokenType getTType() {
        return TType;
    }

    public String getText() {
        return Text;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Token{" +
                "TType=" + TType +
                ", Text='" + Text + '\'' +
                ", index=" + index +
                ", matched=" + matched +
                '}';
    }

    public int getMatched() {
        return matched;
    }

    private final TokenType TType;
    private final String Text;
    int index,matched;
    public Token(TokenType TType,String Text,int index,int matched) {
        this.TType = TType;
        this.Text = Text;
        this.index = index;
        this.matched = matched;
    }
}
