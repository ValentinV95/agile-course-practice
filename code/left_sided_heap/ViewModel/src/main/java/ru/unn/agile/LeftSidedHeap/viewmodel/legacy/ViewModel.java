package ru.unn.agile.LeftSidedHeap.viewmodel.legacy;

import ru.unn.agile.LeftSidedHeap.Model.LeftSidedHeap;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;

public class ViewModel {

    public ViewModel() {
        textRemove = "";
        textAdd = "";
        result = "";
        heap = new LeftSidedHeap<Double>();

        addCollection = new ArrayList<SimpleEntry<Integer, Double>>();
        removeCollection = new ArrayList<Integer>();
        removedCollection = new ArrayList<SimpleEntry<Integer, Double>>();

        isButtonAddEnabled = false;
        isButtonAddEnabled = false;
        status = Status.WAITING;

        result = formatResult();
    }

    public boolean isButtonAddEnabled() {
        return isButtonAddEnabled;
    }

    public boolean isButtonRemoveEnabled() {
        return isButtonRemoveEnabled;
    }

    public void processKeyInTextField() {
        parseInput();
    }

    public void add() {
        if (!parseInput()) {
            return;
        }

        LeftSidedHeap<Double> secondHeap = new LeftSidedHeap<Double>(addCollection);

        heap.merge(secondHeap);

        result = formatResult();
        status = Status.SUCCESS;
    }

    public void remove() {
        if (!parseInput()) {
            return;
        }

        removedCollection.clear();

        for (Integer keyValue : removeCollection) {
            if (heap.isEmpty()) {
                heap.remove(keyValue, removedCollection);
            }
        }

        result = formatResult();
        status = Status.SUCCESS;
    }

    public String getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public String getTextAdd() {
        return this.textAdd;
    }
    public String getTextRemove() {
        return this.textRemove;
    }

    public void setTextAdd(final String textAdd) {
        if (textAdd.equals(this.textAdd)) {
            return;
        }

        this.textAdd = textAdd;
    }

    public void setTextRemove(final String textRemove) {
        if (textRemove.equals(this.textRemove)) {
            return;
        }

        this.textRemove = textRemove;
    }

    public final class Status {
        public static final String WAITING = "Please provide input data";
        public static final String READY = "Press button";
        public static final String BAD_FORMAT_IN_ADD = "Bad format in field add";
        public static final String BAD_FORMAT_IN_REMOVE = "Bad format in field remove";
        public static final String BAD_FORMAT = "Bad format";
        public static final String SUCCESS = "Success";

        private Status() { }
    }

    private boolean correctAdd() {
        try {
            if (!textAdd.isEmpty()) {
                parseTextAdd(textAdd);
            }
        } catch (Exception e) {
            if  (status.equals(Status.BAD_FORMAT_IN_REMOVE)) {
                status = Status.BAD_FORMAT;
            } else {
                status = Status.BAD_FORMAT_IN_ADD;
            }
            return false;
        }

        return true;
    }

    private boolean correctRemove() {
        try {
            if (!textRemove.isEmpty()) {
                parseTextRemove(textRemove);
            }
        } catch (Exception e) {
            if (status.equals(Status.BAD_FORMAT_IN_ADD)) {
                status = Status.BAD_FORMAT;
            } else {
                status = Status.BAD_FORMAT_IN_REMOVE;
            }
            return false;
        }
        return true;
    }

    private boolean parseInput() {
        boolean noExceptionFlag = correctAdd();
        noExceptionFlag = correctRemove() && noExceptionFlag;

        isButtonAddEnabled = !textAdd.isEmpty() && noExceptionFlag;
        isButtonRemoveEnabled = !textRemove.isEmpty() && noExceptionFlag;

        if (noExceptionFlag) {
            if (isButtonAddEnabled || isButtonRemoveEnabled) {
                status = Status.READY;
            } else {
                status = Status.WAITING;
            }
        }

        return (isButtonAddEnabled || isButtonRemoveEnabled);
    }

    private void parseTextAdd(final String input) throws IllegalStateException {
        addCollection.clear();

        String inputWithoutSpace = input.replaceAll("\\s+", "");

        String[] elements = inputWithoutSpace.split(";");

        for (String element: elements) {
            String[] partsElement = element.split("_");
            if (partsElement.length != 2) {
                throw new IllegalStateException("textAdd contains an element not of 2 parts!");
            } else {
                Integer key = Integer.parseInt(partsElement[0]);
                Double value = Double.parseDouble(partsElement[1]);
                addCollection.add(new SimpleEntry<Integer, Double>(key, value));
            }
        }
    }

    private void parseTextRemove(final String input) {
        removeCollection.clear();

        String inputWithoutSpace = input.replaceAll("\\s+", "");

        String[] elements = inputWithoutSpace.split(";");

        for (String element: elements) {
            Integer key = Integer.parseInt(element);
            removeCollection.add(key);
        }
    }

    private String formatResult() {
        Integer size = heap.size();

        String res = "size: " + size.toString() + "\n";
        if (size == 0) {
            res += "min: -\n";
        } else {
            SimpleEntry<Integer, Double> min = heap.getMin();
            res += "min: " + min.toString() + "\n";
        }
        if (removedCollection.isEmpty()) {
            res += "remove: -\n";
        } else {
            res += "remove:";
            for (SimpleEntry<Integer, Double> pairKeyValue: removedCollection) {
                res += " " + pairKeyValue.toString();
            }
            res += "\n";

            removedCollection.clear();
        }

        return res;
    }

    private String textAdd;
    private String textRemove;
    private String result;
    private boolean isButtonAddEnabled;
    private boolean isButtonRemoveEnabled;
    private String status;

    private LeftSidedHeap<Double> heap;
    private Collection<SimpleEntry<Integer, Double>> addCollection;
    private Collection<Integer> removeCollection;
    private Collection<SimpleEntry<Integer, Double>> removedCollection;
}