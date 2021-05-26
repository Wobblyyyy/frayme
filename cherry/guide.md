# cherry - guide
cherry is a sync/async event scheduling framework written in Java designed
for performant concurrent actions.

## So... what's an event?
Events are defined by a relatively simple interface containing an execution
method and a method to determine whether the event has finished. Other than
that... events aren't really anything special. 

## And how do we execute these events?
Events can be executed by manually calling the `run` method. While, yes -
you can do that, events can also be executed by using event executors.
Executors provide a way to control the execution of several events at 
once. You could have an executor capable of controlling 10 or 15 events.

### What about fancy executors?
Executors are pretty cool on their own. But they're even cooler when you
throw in the fact that executors can be conditional. A certain event
can only be executed if a certain set of conditions is met.

On its own, this doesn't really mean all that much. However, it gets more
interesting when you think of what you can do with these events.

## Predicated and conditional events
Conditional events are events that are only executed under a set of conditions.
These conditions are any boolean value. These boolean values are supplied to 
the event using a supplier - who doesn't love some good old functional interfaces?
I know I certainly do.

### Common event conditions
You can use any condition under the sun to decide whether an event should execute
or not. Some common conditions include...
- Time (is the current time within a certain range)
- Execution count (how many times the event has executed)
- Sensor value (is a distance value within a certain range)
- Position (is a position close enough to something)

## Using conditional events for concurrency
Events don't have to be executed within a certain time frame. Events could take
a couple minutes or even a couple hours to process. The important thing to remember
here, however, is that most executors operate within a single thread. There are
some executors that function in an async manner and those are specifically
documented. But the primary executors use a single thread.

If you have an executor that contains 10 events, all of which are predicated on
a couple of conditions, you can tick the executor in a loop continually, thus
evaluating all 10 of the conditions, and thus conditionally execute those events.
Why would this ever be useful? Good question. 
