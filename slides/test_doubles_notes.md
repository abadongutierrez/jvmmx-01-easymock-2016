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

Also known as: *Stub*.

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

Also known as: *Stub*.

How can we verify logic independently when it depends on __indirect inputs__ from other software components?

We replace a real object (DOC) with a test-specific object that __feeds the desired indirect inputs__ into the system under test.

## When to use it

When we have Untested Code caused by our inability to control the __indirect inputs__ of the SUT.

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

It is important to mention that Test Doubles will work only when we can inject dependencies to the SUT so we can inject a test double instead of the real DOC.

## Test Spy

Also know as: Spy or Recording Test Stub

How do we implement __Behavior Verification__?

How can we verify logic independently when it has __indirect outputs__ to other software components?

We use a Test Double to capture the __indirect output__ calls made to another component by the SUT for later verification by the test.

The Test Spy is designed to act as an observation point by recording the method calls made to it by the SUT as it is exercised. During the result verification phase, the test compares the actual values passed to the Test Spy by the SUT with the values expected by the test.

## When to use it

A key indication for using a Test Spy is having an Untested Requirement (see Production Bugs on page 268) caused by an inability to observe the side effects of invoking methods on the SUT.

Unlike a Mock Object, a Test Spy does not fail the test at the first deviation from the expected behavior.

### Variations:

* __Retrieval Interface__:  define the Test Spy as a separate class with a Retrieval Interface that exposes the recorded information.
* __Self Shunt__: (or loopback) collapses the Test Spy and the Testcase Class into a single object called a Self Shunt. Whenever the SUT delegates to the DOC, it is actually calling methods on the Testcase Object, which implements the methods by saving the actual values into instance variables that can be accessed by the Test Method.
* __Inner Test Double__: A popular way to implement the Test Spy as a Hard-Coded Test Double is to code it as an anonymous inner class or block closure within the Test Method and to have this class or block save the actual values into instance or local variables that are accessible by the Test Method.
* __Indirect Output Registry__: another possibility is to have the Test Spy store the actual parameters in a well-known place where the Test Method can access them.

## Mock Object

How do we implement Behavior Verification for __indirect outputs__ of the SUT?

How can we verify logic independently when it depends on __indirect inputs__ from other software components?

We replace an object on which the SUT depends on with a test-specific object that verifies it is being used correctly by the SUT.

A Mock Object is a powerful way to implement Behavior Verification.

We configure the Mock Object with the values with which it should respond to the SUT and the method calls (complete with expected arguments) it should expect from the SUT. When called during SUT execution, the Mock Object compares the actual arguments received with the expected arguments using Equality Assertions and fails the test if they don't match. *The test need not make any assertions at all!*

## When to use it

To use a Mock Object, we must be able to predict the values of most or all arguments of the method calls before we exercise the SUT.

Mock Objects can be either "strict" or "lenient" (sometimes called "nice"). A "strict" Mock Object fails the test if the calls are received in a different order than was specified when the Mock Object was programmed. A "lenient" Mock Object tolerates out-of-order calls.

Tests written using Mock Objects look different from more traditional tests because all the expected behavior must be specified before the SUT is exercised.

## Fake Object

Also know as: Dummy.

How can we verify logic independently when depended-on objects cannot be used?

How can we avoid Slow Tests?

We replace a component that the SUT depends on with a much lighter-weight implementation.

A Fake Object is a much simpler and lighter-weight implementation of the functionality provided by the DOC without the side effects we choose to do without.

This implementation need not have any of the "-ilities" that the real DOC needs to have (such as scalability); it need provide only the equivalent services to the SUT so that the SUT remains unaware it isn't using the real DOC.

## When to use it

We should use a Fake Object whenever the SUT depends on other components that are unavailable or that make testing difficult or slow.

## Variations:

* __Fake Database__: With the Fake Database pattern, the real database or persistence layer is replaced by a Fake Object that is functionally equivalent but that has much better performance characteristics. Like replacing the database with a set of in-memory HashTables.
* __In-Memory Database__: Another example of a Fake Object is the use of a small-footprint, diskless database instead of a full-featured disk-based database.
* __Fake Web Service__: When testing software that depends on other components that are accessed as Web services, we can build a small hard-coded or data-driven implementation that can be used instead of the real Web service to make our tests more robust and to avoid having to create a test instance of the real Web service in our development environment.
* __Fake Service Layer__: When testing user interfaces, we can avoid Data Sensitivity (see Fragile Test) and Behavior Sensitivity (see Fragile Test) of the tests by replacing the component that implements the Service Layer (including the domain layer) of our application with a Fake Object that returns remembered or data-driven results.

