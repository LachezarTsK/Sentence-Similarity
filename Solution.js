
/**
 * @param {string[]} firstSentence
 * @param {string[]} secondSentence
 * @param {string[][]} similarPairs
 * @return {boolean}
 */
var areSentencesSimilar = function (firstSentence, secondSentence, similarPairs) {
    if (firstSentence.length !== secondSentence.length) {
        return false;
    }

    const mapSimilarPairs = new Map();
    for (let i = 0; i < similarPairs.length; ++i) {
        if (!mapSimilarPairs.has(similarPairs[i][0])) {
            mapSimilarPairs.set(similarPairs[i][0], new Set());
        }
        mapSimilarPairs.get(similarPairs[i][0]).add(similarPairs[i][1]);
    }

    for (let i = 0; i < firstSentence.length; ++i) {
        if (firstSentence[i] === secondSentence[i]) {
            continue;
        }
        if (mapSimilarPairs.has(firstSentence[i])
                && mapSimilarPairs.get(firstSentence[i]).has(secondSentence[i])) {
            continue;
        }
        if (mapSimilarPairs.has(secondSentence[i])
                && mapSimilarPairs.get(secondSentence[i]).has(firstSentence[i])) {
            continue;
        }
        return false;
    }

    return true;
};
