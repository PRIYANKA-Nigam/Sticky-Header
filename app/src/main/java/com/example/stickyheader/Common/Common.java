package com.example.stickyheader.Common;

import com.example.stickyheader.Model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common { public static final int VIEWTYPE_GROUP = 0;public static final int VIEWTYPE_PERSON = 1;
    public static final int RESULT_CODE =1000 ;public  static List<String> alphabet_available=new ArrayList<>();
    public static ArrayList<Person> sortList(ArrayList<Person> people){ Collections.sort(people, new Comparator<Person>() {@Override
            public int compare(Person person, Person t1) { return person.getName().compareTo(t1.getName()); }});return people; }
    public static ArrayList<Person> arrayList(ArrayList<Person> list){ int i;ArrayList<Person> customList=new ArrayList<>();
        Person person=new Person();person.setName(String.valueOf(list.get(0).getName().charAt(0)));person.setViewType(VIEWTYPE_GROUP);
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0)));customList.add(person);
        for (i=0;i<list.size()-1;i++){ Person person1=new Person();
            char name1=list.get(i).getName().charAt(0);char name2=list.get(i+1).getName().charAt(0);
            if (name1==name2){ list.get(i).setViewType(VIEWTYPE_PERSON); customList.add(list.get(i));
            }else { list.get(i).setViewType(VIEWTYPE_PERSON);customList.add(list.get(i));
                person1.setName(String.valueOf(name2));person1.setViewType(VIEWTYPE_GROUP);
                alphabet_available.add(String.valueOf(name2));customList.add(person1); } }
        list.get(i).setViewType(VIEWTYPE_PERSON);customList.add(list.get(i));return customList; }
    public static int findPosWithName(String name,ArrayList<Person> list){ for (int i=0;i<list.size();i++){
        if (list.get(i).getName().equals(name)) return i; }return -1; }
    public static ArrayList<String> genAlpha(){ ArrayList<String> result=new ArrayList<>(); for (int i=65;i<=90;i++){ char ch=(char)i;
            result.add(String.valueOf(ch)); }return result; }
            public static ArrayList<Person> getPeopleGroup() { ArrayList<Person> people=new ArrayList<>();
        Person person=new Person("Andy","Direction",-1);people.add(person);
        person=new Person("Frandy","Direction",-1); people.add(person);
         person=new Person("Mandy","Direction",-1); people.add(person);
         person=new Person("Randy","Direction",-1); people.add(person);
         person=new Person("kenny","Direction",-1); people.add(person);
         person=new Person("Roxi","Direction",-1);people.add(person);
         person=new Person("Vesa","Direction",-1);people.add(person);
         person=new Person("Ron","Direction",-1);people.add(person);
         person=new Person("Hengry","Direction",-1);people.add(person);
         person=new Person("Senial","Direction",-1);people.add(person);
         person=new Person("Nat","Direction",-1);people.add(person); return people; }}
