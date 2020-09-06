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

### Probable solution :P?
- Our requirements from the user perspective:
  - **I want users Not to have a weak password.**

- Our requirements from a CTO's perspective:
  - **I want to Avoid database reads 'FOR EVERY USER'.**
  - **I want a 100% match if a user has entered a weak password.**
  - **I want the above to happen and happen QUICKLY.**

We have to check for set membership. The nearest data structure that performs
that incredibly fast is a Map/dictionary. Can we store the data in it, a little
smartly? Instead of storing actual passwords/hashed passwords with salt etc,
can a set of single bits be as good as the actual password that we want to store?

Think over it for some time, and then come back here.

### Probabilistic data structure to the rescue!

It can be represented as a set of bits in an array. We will delve into the structure
part of the data-structure later. We only care about the fact that a weak password
should be identified correctly and there should be almost no database reads while
it does so (which would be costly on the resources and on the pocket as well).

You can read about this data structure from numerous sources, which
do an incredible job of explaining the architecture in detail. Some of
those sources are listed below in **Credits**.

## Credits

- [The original paper by Burton Bloom](https://dl.acm.org/doi/10.1145/362686.362692)
- [Bloom Filter in Network Applications](http://citeseerx.ist.psu.edu/viewdoc/download;jsessionid=3F47EA042DE40EFEEE7CA19E8A359C29?doi=10.1.1.20.98&rep=rep1&type=pdf)
- [Bloom Filter in weak password detection]()
- [Understand the architecture of Bloom Filters](https://hackernoon.com/probabilistic-data-structures-bloom-filter-5374112a7832)