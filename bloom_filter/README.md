# Bloom Filters - Probabilistic data structure
A data structure which is probabilistic in nature and comes in handy
in places galore.

Technically, what it does is it tests for set-membership of an element.

## Probabilistic - How?
**P.S: The word *confidence* used here is not the mathematically one -
it's a conversational one!**

This data structure returns  a **NO** with 100% confidence if something
is not present in it.

This data structure returns a **YES** with some **k** percentage
confidence if something is present in it.

## How is it different from HashMap/HashSet/Dictionary ?

Hash-function based data-structures do the same thing - and that too,
with 100% confidence! Then why do we need this anyway?

## Answering the When and Where?

**Problem #1:**
```
 You are the owner of a personal blogging website, which has
a login mechanism. Recently, you have been notified by a security expert
that your users are having easily crackable passwords, and even though
you are not storing the passwords in plain-text, it can be exposed
easily. So, you have to work on a feature which notifies users to change
their passwords to something more secure, and help them move away from
easily hackable passwords.
The security expert has provided a list of weak passwords and has asked you
to make sure none of the user keep such passwords. You have to specifically
do this.
Avoid having user passwords from the list of weak passwords.
```
**First Solution:**
```
Assuming that the list of weak passwords is in a txt file, you can read
the list of passwords in-memory in a python dictionary. Since, dictionaries
have a worst case lookup time complexity of O(1), you will have no issues
in dealing with it. The python dictionary/java hashmap is an in-memory
data-structure, so as long as the size of the hashmap does not equal the
size of the RAM, this approach is workable.
```
**Now, comes a twist in tale:**
```
Suddenly, you realise that the list of passwords provided by the security expert
is not as trivial as you thought it was. The list is definitely there, but
it's huge! You notice that while you load the weak-password list in the dictionary,
and do a check for that on your server side, you face slight slowing down
of your server code. This might mean that the list is not able to fit
completely in the dictionary at once, and thrashing has started.
```
You might suggest,
```
'oh let's increase the size of the RAM and BAMM.. it's done!'
```

Well yes, possible way and much easier one. But, once you spend time in this
industry, you realise you are eventually going to hit that bottleneck again
some time in future, and it's going to haunt you again. Or your CEO might come
up and tell you,
```
'Dude! you neither have the money nor the resources to do that!'
'Think of something else!'
```

You, being you, have to figure out a different approach to find a solution
to this problem!

**Focussing back On The Problem**
- Is that list a static list? Will no new weak passwords be inserted in that
list, ever?
- If the list is huge, why can't we store it in a database? And rely on a cache
to do this job?


## Can we rely on probability ?


## Credits?