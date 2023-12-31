package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
import ru.ravvcheck.itmo.springLabs.forms.SpaceMarineBuild;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class AddCommand extends AbstractCommand {
    public AddCommand(Supervisor supervisor) {
        super("add", "Добавить новый элемент в коллекцию", supervisor);
    }

    @Override
    public void execute(String args) throws WrongValuesException {
        SpaceMarineBuild spaceMarineBuild = new SpaceMarineBuild(supervisor.getScanner());
        this.supervisor.getDatabase().addItem(spaceMarineBuild.build());
        System.out.println("Объект создан");
        supervisor.getDatabase().sortData();
    }
}
