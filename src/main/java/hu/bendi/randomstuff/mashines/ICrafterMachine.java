package hu.bendi.randomstuff.mashines;

public interface ICrafterMachine {

    IMachineData data = null;

    IOutputData craft(IInputData input);

    public interface IInputData {

    }

    public interface IOutputData {

    }

    public interface IMachineData {
        void apply(IInputData data);

        void apply(IOutputData data);
    }
}
