package FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String person = scan.nextLine();
        List<String> personNameAge = new ArrayList<>(2);

        Map<String, String> dataPersons = new LinkedHashMap<>();
        Map<String, String> collectPersons = new LinkedHashMap<>();

        Map<String, Person> mapPersons = new LinkedHashMap<>();
        mapPersons.put(person, new Person());
        String input = scan.nextLine();

        while (!"End".equals(input)) {

            if (input.contains(" - ")) {

                String[] tokens = input.split(" - ");
                collectPersons.put(tokens[0], tokens[1]);
            } else {
                String[] tokens = input.split(" ");
                String firstName = tokens[0];
                String secondName = tokens[1];
                String age = tokens[2];
                String name = firstName + " " + secondName;
                dataPersons.put(name, age);
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, String> stringStringEntry : collectPersons.entrySet()) {

            if (stringStringEntry.getKey().equals(person) || stringStringEntry.getValue().equals(person)) {//////////

                if (stringStringEntry.getKey().contains("/")) {//////////////
                    String names = getKeysByValue(dataPersons, stringStringEntry.getKey());
                    personNameAge.add(names);
                    personNameAge.add(stringStringEntry.getKey());
                } else {
                    String name = stringStringEntry.getKey();
                    String age = dataPersons.get(name);
                    personNameAge.add(name);
                    personNameAge.add(age);
                }

                if (stringStringEntry.getValue().contains("/")) {//////////////
                    String names2 = getKeysByValue(dataPersons, stringStringEntry.getValue());
                    String agePersonnn2 = dataPersons.get(stringStringEntry.getValue());
                    personNameAge.add(names2);
                    personNameAge.add(agePersonnn2);
                } else {
                    String name = stringStringEntry.getKey();
                    String age = dataPersons.get(name);
                    personNameAge.add(name);
                    personNameAge.add(age);
                }

            } else if (stringStringEntry.getKey().equals(getKeysByValue(dataPersons, person)) || stringStringEntry.getValue().equals(getKeysByValue(dataPersons, person))) {

                if (stringStringEntry.getKey().equals(getKeysByValue(dataPersons, person))) {
                    if (stringStringEntry.getKey().contains("/")) {//////////////
                        String names = getKeysByValue(dataPersons, person);
                        personNameAge.add(names);
                        personNameAge.add(stringStringEntry.getKey());
                    } else if (!getKeysByValue(dataPersons, person).contains("/")) {
                        String name = stringStringEntry.getKey();
                        String age = dataPersons.get(name);
                        personNameAge.add(name);
                        personNameAge.add(age);
                    }
                } else if (stringStringEntry.getValue().equals(getKeysByValue(dataPersons, person))) {

                    if (stringStringEntry.getValue().contains("/")) {//////////////
                        String names2 = getKeysByValue(dataPersons, stringStringEntry.getValue());
                        String agePersonnn2 = dataPersons.get(stringStringEntry.getValue());
                        personNameAge.add(names2);
                        personNameAge.add(agePersonnn2);
                    } else {
                        String name = stringStringEntry.getValue();
                        String age = dataPersons.get(name);
                        personNameAge.add(name);
                        personNameAge.add(age);
                    }
                }

            }

            if (stringStringEntry.getValue().equals(getKeysByValue(dataPersons, person)) || stringStringEntry.getValue().equals(dataPersons.get(person))) {/////////////

                if (dataPersons.containsKey(stringStringEntry.getKey()) && stringStringEntry.getValue().equals(person)) {

                    if (stringStringEntry.getKey().contains("/")) {
                        String nameParents = getKeysByValue(dataPersons, stringStringEntry.getKey());
                        String ageParents = stringStringEntry.getKey();
                        Parents parents = new Parents(nameParents, ageParents);
                        mapPersons.get(person).getParents().add(parents);
                    } else {
                        Parents parents = new Parents(stringStringEntry.getKey(), dataPersons.get(stringStringEntry.getKey()));
                        mapPersons.get(person).getParents().add(parents);
                    }
                } else if (dataPersons.containsKey(stringStringEntry.getKey()) && stringStringEntry.getValue().equals(dataPersons.get(person))) {
                    if (stringStringEntry.getKey().contains("/")) {
                        String nameParents = getKeysByValue(dataPersons, stringStringEntry.getKey());
                        String ageParents = stringStringEntry.getKey();
                        Parents parents = new Parents(nameParents, ageParents);
                        mapPersons.get(person).getParents().add(parents);
                    } else {
                        Parents parents = new Parents(stringStringEntry.getKey(), dataPersons.get(stringStringEntry.getKey()));
                        mapPersons.get(person).getParents().add(parents);
                    }
                }else if(dataPersons.containsKey(stringStringEntry.getKey()) && stringStringEntry.getValue().equals(getKeysByValue(dataPersons,person))){
                    if (stringStringEntry.getKey().contains("/")) {
                        String nameParents = getKeysByValue(dataPersons, stringStringEntry.getKey());
                        String ageParents = stringStringEntry.getKey();
                        Parents parents = new Parents(nameParents, ageParents);
                        mapPersons.get(person).getParents().add(parents);
                    } else {
                        Parents parents = new Parents(stringStringEntry.getKey(), dataPersons.get(stringStringEntry.getKey()));
                        mapPersons.get(person).getParents().add(parents);
                    }
                }

                if (dataPersons.containsValue(stringStringEntry.getKey()) && stringStringEntry.getValue().equals(person)) {
                    if (stringStringEntry.getKey().contains("/")) {
                        String nameParents = getKeysByValue(dataPersons, stringStringEntry.getKey());
                        String ageParents = stringStringEntry.getKey();
                        Parents parents = new Parents(nameParents, ageParents);
                        mapPersons.get(person).getParents().add(parents);
                    } else {
                        Parents parents = new Parents(stringStringEntry.getKey(), dataPersons.get(stringStringEntry.getKey()));
                        mapPersons.get(person).getParents().add(parents);
                    }

                } else if (dataPersons.containsValue(stringStringEntry.getKey()) && stringStringEntry.getValue().equals(dataPersons.get(person))) {/////
                    if (stringStringEntry.getKey().contains("/")) {
                        String nameParents = getKeysByValue(dataPersons, stringStringEntry.getKey());
                        String ageParents = stringStringEntry.getKey();
                        Parents parents = new Parents(nameParents, ageParents);
                        mapPersons.get(person).getParents().add(parents);
                    } else {
                        Parents parents = new Parents(stringStringEntry.getKey(), dataPersons.get(stringStringEntry.getKey()));
                        mapPersons.get(person).getParents().add(parents);
                    }
                }else if(dataPersons.containsValue(stringStringEntry.getKey()) && stringStringEntry.getValue().equals(getKeysByValue(dataPersons,person))){
                    if (stringStringEntry.getKey().contains("/")) {
                        String nameParents = getKeysByValue(dataPersons, stringStringEntry.getKey());
                        String ageParents = stringStringEntry.getKey();
                        Parents parents = new Parents(nameParents, ageParents);
                        mapPersons.get(person).getParents().add(parents);
                    } else {
                        Parents parents = new Parents(stringStringEntry.getKey(), dataPersons.get(stringStringEntry.getKey()));
                        mapPersons.get(person).getParents().add(parents);
                    }
                }
            }


            if (stringStringEntry.getKey().equals(person) || stringStringEntry.getKey().equals(dataPersons.get(person))) {
                if (dataPersons.containsKey(stringStringEntry.getValue())) {
                    if (stringStringEntry.getKey().contains("/")) {
                        String nameChildren = getKeysByValue(dataPersons, stringStringEntry.getValue());
                        String ageChildren = stringStringEntry.getValue();
                        Children children = new Children(nameChildren, ageChildren);
                        mapPersons.get(person).getChildren().add(children);
                    } else {
                        Children children = new Children(stringStringEntry.getValue(), dataPersons.get(stringStringEntry.getValue()));
                        mapPersons.get(person).getChildren().add(children);
                    }
                } else if (dataPersons.containsValue(stringStringEntry.getKey())) {
                    if (stringStringEntry.getKey().contains("/")) {
                        String nameChildren = getKeysByValue(dataPersons, stringStringEntry.getValue());
                        String ageChildren = stringStringEntry.getValue();
                        Children children = new Children(nameChildren, ageChildren);
                        mapPersons.get(person).getChildren().add(children);
                    } else {
                        Children children = new Children(stringStringEntry.getValue(), dataPersons.get(stringStringEntry.getValue()));
                        mapPersons.get(person).getChildren().add(children);
                    }
                }

            }
        }
        System.out.println(personNameAge.get(0) + " " + personNameAge.get(1));
        mapPersons.forEach((key, value) -> {
            System.out.println("Parents:");
            for (Parents parent : value.getParents()) {
                System.out.println(parent);
            }
            System.out.println("Children:");
            for (Children child : value.getChildren()) {
                System.out.println(child);
            }
        });
    }

    private static String getKeysByValue(Map<String, String> dataPersons, String key) {
        String keys = "";
        for (Map.Entry<String, String> entry : dataPersons.entrySet()) {
            if (entry.getValue().equals(key)) {
                keys = entry.getKey();
            }
        }
        return keys;
    }
}
