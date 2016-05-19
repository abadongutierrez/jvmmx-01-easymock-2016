# Test Doubles

They are also know as: Imposters

Sometimes it is hard to test the SUT (System under test) because it depends on other components that cannot be use in
the test environment.

Why?
* the component is not available
* they is not returning the results needed for the test
* executing them would have undesirable side effects
* we need more control over or visibility the internal behaviour of the SUT

When we cannot use a DOC (depended-on-component) we can replace it with a Test Double.

## Four-Phase Test

The Four-Phase test is a way to structure the logic in our test to make obvious what we are testing.

* In the first phase (Setup), we set up the test fixture that is required for the SUT to exhibit the expected
behaviour.
* In the second phase (Exercise), we interact with the SUT.
* In the third phase (Verify), we do whaever is necessary to determine whether the expected outcome has been
obtained.
* In the fourth phase (Teardown), we tear down the text fixture to put the worl back to the state in which
we found it.

A __test fixture__ is a fixed state of a set of objects used as a baseline for running tests.

## What are indirect inputs and outputs?

The depended-on component (DOC) may return values or throw exceptions that affect the behavior of the SUT, but it may prove difficult or impossible to cause certain cases to occur. The indirect inputs received from the DOC may be unpredictable (such as the system clock or calendar).

### Why Do We Care about Indirect Inputs?

Calls to DOCs often return objects or values, update their arguments or even throw exceptions. Many of the execution paths within the SUT are intended to deal with these return values and to handle the possible exceptions.

*Not all inputs of the SUT come from the test. Some indirect inputs come from other components called by the SUT in the form of return values, updated parameters, or exceptions thrown.*

### Why Do We Care about Indirect Outputs?

The concept of encapsulation often directs us to not care about how something is implemented. After all, that is the whole purpose of encapsulation.

Consider for a moment a component that has a method in its API that returns nothing—or at least nothing that can be used to determine whether it has performed its function correctly. In this situation, we have no choice but to test through the back door.

A client of the logger may specify that the logger be called when certain conditions are met. These calls will not be visible on the client's interface but would typically be a requirement that the client needs to satisfy and, therefore, would be something we want to test. The circumstances that should result in a messaging being logged are indirect output test conditions (Figure 11.2) for which we need to write tests so that we can avoid having Untested Requirements (see Production Bugs).

*Not all outputs of the SUT are directly visible to the test. Some indirect outputs are sent to other components in the form of method calls or messages.*

In other cases, the SUT does produce visible behavior that can be verified through the front door but also has some expected side effects. Both outputs need to be verified in our tests.

## Test Stub

How can we verify logic independently when it depends on __indirect inputs__ from other software components?

We replace a real object (DOC) with a test-specific object that __feeds the desired indirect inputs__ into the system under test.

### Variations:

* __Responder__: A Test Stub that is used to inject *valid indirect inputs* into the SUT.
* __Saboteur__: A Test Stub that is used to inject *invalid indirect inputs* into the SUT. Its purpose is to derail whatever the SUT is trying to do so that we can see how the SUT copes under these circumstances. 
* __Temporary Test Stub__: A Temporary Test Stub stands in for a DOC that is not yet available.
* __Procedural Test Stub__:
* __Entity Chain Snipping__: This is a variation of a __Responder__. It is used to replace a complex network of objects. Its inclusion
can make the test fixture setup more quickly and make the test easier to understand.

__IMPORTANT__: We really should have at least one test that verifies the SUT works without a Test Stub.

### Implementations

* __Hard Coded Test Stub__: This tend to be used for a single test or a very small number of tests.
* __Configurable Test Stub__: there are tools like EasyMock!

