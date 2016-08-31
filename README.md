Chromosome fragmentation
========================

An algorithm to recombine the fragments of a chromosome.

The application parses the FASTA formatted input into a collection of fragment objects. A fragment is composed of a
description and a nucleotide sequence. These fragments are then zipped together using the simple zipper.

The simple zipper is an implementation of the zipper function from a collection of fragments to the entire
reconstructed chromosome represented as a string.

Usage
-----

To run the application:

    sbt "run"

Testing
-------

To tun the tests:

    sbt test
