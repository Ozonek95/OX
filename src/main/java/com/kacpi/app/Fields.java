package com.kacpi.app;

import java.util.Iterator;


/**
 * @author Kacper Staszek
 */
class Fields implements Iterable{

    Field[][] pola;
    private ITERATOR_KIND iteratorWeWantNow = ITERATOR_KIND.HOR;

    @Override
    public Iterator iterator() {
        Iterator verticalIterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
        Iterator horizontalIterator = new Iterator() {
            //TODO: true class with a constructor
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < pola.length;
            }

            public boolean hasPrevious() {
                return current > 0;
            }

            @Override
            public Field next() {
                return pola[current][current + 1];
            }
        };

        switch (iteratorWeWantNow) {
            case HOR:
                return horizontalIterator;
            case VER:
                return verticalIterator;
        }
        return null;
    }

}
