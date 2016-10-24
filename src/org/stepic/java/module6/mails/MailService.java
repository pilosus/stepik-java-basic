package org.stepic.java.module6.mails;

import java.util.*;
import java.util.function.*;


/**
 * Created by vitaly on 09/10/16.
 */
public class MailService<T> implements Consumer<Sendable<T>> {

    //public Map<String, List<T>> map = new LinkedHashMap<String, List<T>>();

    public Map<String, List<T>> map = new HashMap<String, List<T>>() {
        /**
         * HashMap get method override return an empty LinkedList instead of null if key's not found.
         * @param key
         * @return
         */
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, new LinkedList<T>());
        }
    };

    public Map<String, List<T>> getMailBox() {
        return this.map;
    }

    @Override
    public void accept(Sendable<T> tSendable) throws NullPointerException {
        // fill up a Map
        String key = tSendable.getTo();
        // if there's no key, create one
        if (!map.containsKey(key)) {
            map.put(key, new LinkedList<T>());
        }
        // create value for the key: value is a list, so add an item to it
        map.get(key).add(tSendable.getContent());
    }

}
