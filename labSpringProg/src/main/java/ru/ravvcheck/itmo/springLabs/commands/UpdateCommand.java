package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
import ru.ravvcheck.itmo.springLabs.forms.SpaceMarineBuild;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class UpdateCommand extends AbstractCommand {
    public UpdateCommand(Supervisor supervisor) {
        super("update", "Обновить значение элемента коллекции, id которого равен заданному", supervisor);
    }

    @Override
    public void execute(String args) throws WrongValuesException {
        try {
            SpaceMarineBuild spaceMarineBuild = new SpaceMarineBuild(supervisor.getScanner());
            int id = Integer.parseInt(args);
            if (this.haveId(id)) {
                this.supervisor.getDatabase().addItem(spaceMarineBuild.build());
            } else {
                System.out.println("Объект с таким id не найден");
            }
        } catch (NumberFormatException e) {
            System.out.println("Поле id должно быть integer");
        }
    }
}
