interface Quest {
    void process();
}

class DeadIslandQuest implements Quest {

    public void process() {
        System.out.println("Done the Dead Island Quest!");
    }

}

class EliteKnightQuest implements Quest {

    public void process() {
        System.out.println("Done the Elite Knight Quest!");
    }

}

class Knight {
    private Quest quest;

    Knight(Quest quest) {
        this.quest = quest;
    }

    void Questing() {
        quest.process();
    }
}

class App {
    public static void main(String[] args) {
        Knight knight = new Knight(new DeadIslandQuest());

        knight.Questing();
    }
}