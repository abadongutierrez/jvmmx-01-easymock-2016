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

A test fixture is a fixed state of a set of objects used as a baseline for running tests.

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

