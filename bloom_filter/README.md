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

- Is that list a static list? Will no newer weak passwords be inserted in that
list, ever?
```
If you think a little, you might answer a No. It is entirely possible
that there are newer weak passwords out there in the world which needs
to be avoided at any cost. So, No.., it is not going to be a static list.
```

- If the list is huge, why can't we store it in a database?
```
Yes, we can! Insert the passwords in a database. But, this would create a
big problem. For every password change coming to the server, you would
have to make a database read call to check if this password is present
in the database or not. The disk reads are really slow -if you have worked
with databases before, you know that already. The number of reads hitting
your database will be huge and might slow down every user interacting with
it.
```

- But wait, what about cache?
```
Yes, we can! But this is same as having an in-memory data structure. We
have already discussed. That was our first solution to this. So, it won't
really be helpful. Also, if you think about cache - such systems are
used to keep things which are frequently accessed. There is no guarantee,
in fact it is impossible that users all over the world, who are using
your application will try to keep the same password or similar passwords,
which are weak.
For example:
If the cache has current passwords as: ['12345', '98765', 'apple', 'tom']
Everyone all over the world, is not going to pick such weak passwords,
so even that argument fails that cache would be helpful. There would always
be some passwords which are not present in cache, and it would force
the system to do a database read.

Another problem: Even for users who enter secure passwords, using this
method, will anyway go to do a database read. After getting the response,
it is going to figure out that this password does not belong to the list
of prohibited/weak passwords. So, cache is not at all a solution for this
problem.
```

### Problem Statement

Given a set of weak passwords, I want to test for set membership of a newly
entered password by a user.

**Constraints:**

- I cannot use a simple hashing data structure as per (i).
- I cannot use a simple database as per (ii).
- I cannot use a cache on top of the database as per (iii).
- Owing to the 2nd bullet, space is a constraint.
- Owing to the 2nd and 3rd bullet, time is a constraint.



Can we try to decrease the amount of database reads substantially, at the very least?
```
When we want to decrease database reads drastically, and in a case, where using
cache does not seem an option, can we have some sort of fuzziness in between?

A probable error
```
- What next?
```
Our requirements from the user perspective:
#############################################
#1. I want users Not to have a weak password.
#############################################
```

Our requirements from a CTO's perspective:
#############################################
#2. I want to Avoid database reads 'FOR EVERY USER'.
#3. I want a 100% match if a user has entered a weak password.
#############################################

## Can we rely on probability ?
```
Probabilistic data structure to the rescue!
```

## Credits?
```
The paper in question, listed in the references below, sheds some light
on having a data-structure which will come in handy when you have the
following requirements.
```