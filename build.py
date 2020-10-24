import logging
import build_utils

###################################################################
#                           BASE STAGE                            #
###################################################################
class Stages:
    def __init__(self, stage_name):
        self.stage_name = stage_name

    def __repr__(self):
        print("repr: [name:{0}]".format(__name__))

    def run(self):
        pass


###################################################################
#                       BUILD                                     #
###################################################################
class Build(Stages):
    __name__ = 'build'
    def __init__(self, stage):
        super().__init__(__name__)

    def run(self):
        pass


###################################################################
#                       TEST                                      #
###################################################################
class Test(Stages):
    def __init__(self):
        __name__ = 'test'
        super().__init__(__name__)

    def run(self):
        pass


###################################################################
#                         COMPILE                                 #
###################################################################
class Compile(Stages):
    __name__ = 'compile'

    def __init__(self):
        super().__init__(stage_name=__name__)

    def run(self):
        #TODO Get the list of directories containing the py/java files
        _f = build_utils.get_dirs()
        #TODO Compile/Run then one by one
        #TODO Use a logger
        pass


###################################################################
#                      STAGES RUNNER                              #
###################################################################
class StageRunner:
    def __init__(self, *args):
        """
        :param kwargs: dictionary of stages inheriting Stages class
        """
        assert args is not  None and len(args) != 0
        self.stages = args

    def run(self):
        for stage in self.stages:
            stage.run()

    def validate(self):
        for stage in self.stages:
            stage.run()


###################################################################
#
###################################################################
if __name__ == '__main__':
    stage_runner = StageRunner()
    stage_runner.run()