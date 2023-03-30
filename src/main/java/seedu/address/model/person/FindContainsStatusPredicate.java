package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class FindContainsStatusPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public FindContainsStatusPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsStatusIgnoreCase(person.getStatus(), keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindContainsStatusPredicate // instanceof handles nulls
                && keywords.equals(((FindContainsStatusPredicate) other).keywords)); // state check
    }

}