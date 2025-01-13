
package main

import "fmt"

func areSentencesSimilar(firstSentence []string, secondSentence []string, similarPairs [][]string) bool {
    if len(firstSentence) != len(secondSentence) {
        return false
    }

    mapSimilarPairs := map[string]HashSet{}
    for i := range similarPairs {
        if _, containsKey := mapSimilarPairs[similarPairs[i][0]]; !containsKey {
            mapSimilarPairs[similarPairs[i][0]] = NewHashSet()
        }
        mapSimilarPairs[similarPairs[i][0]].Add(similarPairs[i][1])
    }

    for i := range len(firstSentence) {
        if firstSentence[i] == secondSentence[i] {
            continue
        }
        if _, containsKey := mapSimilarPairs[firstSentence[i]]; containsKey && 
            mapSimilarPairs[firstSentence[i]].Contains(secondSentence[i]) {
            continue
        }
        if _, containsKey := mapSimilarPairs[secondSentence[i]]; containsKey && 
            mapSimilarPairs[secondSentence[i]].Contains(firstSentence[i]) {
            continue
        }
        return false
    }

    return true
}

type HashSet struct {
    conainer map[string]bool
}

func NewHashSet() HashSet {
    return HashSet{conainer: map[string]bool{}}
}

func (this HashSet) Contains(element string) bool {
    return this.conainer[element]
}

func (this HashSet) Add(element string) {
    this.conainer[element] = true
}

func (this HashSet) Remove(element string) {
    delete(this.conainer, element)
}

func (this HashSet) getKeys() []string {
    keys := make([]string, len(this.conainer))
    index := 0
    for key := range this.conainer {
        keys[index] = key
        index++
    }
    return keys
}
