public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id); // вызов родительского конструктора (число)
        this.title = title; // название
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
            return false;
    }
}