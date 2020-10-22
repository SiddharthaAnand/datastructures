import logging

class Stages:
    def __init__(self, stage_name):
        self.name = stage_name


class Build(Stages):
    pass


class Test(Stages):
    pass


class Compile(Stages):
    pass


class StageRunner:
    def __init__(self, **kwargs):
        pass

