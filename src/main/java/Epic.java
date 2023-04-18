    public class Epic extends Task {
        protected String[] subtasks;

        public Epic(int id, String[] subtasks) {
            super(id); // вызов родительского конструктора  (число)
            this.subtasks = subtasks; // заполнение своих полей массив из подзадач,
            // каждая из которых является простым текстом (String);
        }

        public String[] getSubtasks() {
            return subtasks;
        }

        @Override
        public boolean matches(String[] query) {
            String[] tmp = new String[query.length + 1];
            if ( int i = 0; i < query.length; i++;){
                tmp[i] = query[i];
            }
           return tmp;
        }
    }