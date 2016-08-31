Chromosome fragmentation
========================

An algorithm to recombine the fragments of a chromosome.

The application parses the FASTA formatted input into a collection of fragment objects. A fragment is composed of a
description and a nucleotide sequence. These fragments are then zipped together using the simple zipper.

The sequential zipper is an implementation of the zipper function that takes a collection of fragments and evaluates
the entire reconstructed chromosome represented as a string.

The sequential zipper function walks through the collection of fragments as sources and as destinations and checks to
see whether the source fragment can be linked to the destination fragment. This is essentially an order N squared
algorithm. The efficiency is improved by keeping track of destination fragments already linked and this conveniently
leaves the solitary fragment representing the initial fragment. Also when a link is found for a source there is no
need to continue iterating the destinations. There is quite a lot of scope to parallelize the algorithm.

Usage
-----

To run the application:

    sbt "run"

Testing
-------

To tun the tests:

    sbt test
